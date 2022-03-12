package uz.ixtiyor21.trello_magic.service.organization;

import org.springframework.stereotype.Service;
import uz.ixtiyor21.trello_magic.config.Session;
import uz.ixtiyor21.trello_magic.dto.org.OrganizationCreateDto;
import uz.ixtiyor21.trello_magic.dto.org.OrganizationDto;
import uz.ixtiyor21.trello_magic.dto.org.OrganizationUpdateDto;
import uz.ixtiyor21.trello_magic.entity.org.Organization;
import uz.ixtiyor21.trello_magic.enums.status.Status;
import uz.ixtiyor21.trello_magic.mapper.organization.OrganizationMapper;
import uz.ixtiyor21.trello_magic.repository.auth.AuthUserRepository;
import uz.ixtiyor21.trello_magic.repository.organization.OrganizationRepository;
import uz.ixtiyor21.trello_magic.service.AbstractService;
import uz.ixtiyor21.trello_magic.service.file.FileUploadService;
import uz.ixtiyor21.trello_magic.utils.BaseUtils;
import uz.ixtiyor21.trello_magic.validator.org.OrganizationValidator;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 9:41
 * Project : Trello_magic
 */
@Service
public class OrganizationService extends AbstractService<OrganizationRepository, OrganizationMapper, OrganizationValidator> {

    private final AuthUserRepository authUserRepository;
    public Integer page = 1;

    protected OrganizationService(OrganizationRepository repository, OrganizationMapper mapper, OrganizationValidator validator, BaseUtils baseUtils, AuthUserRepository authUserRepository) {
        super(repository, mapper, validator, baseUtils);
        this.authUserRepository = authUserRepository;
    }

    public void create(OrganizationCreateDto organizationCreateDto) {
        try {
            String path = FileUploadService.saveOrgImage(organizationCreateDto.getLogo_file());
            Organization organization = mapper.fromCreateDto(organizationCreateDto);
            organization.setCreated_at(Instant.now());
            organization.setCreated_by(Session.getSession().getId());
            organization.setLogo_path(path);
            organization.setCode(String.valueOf(System.currentTimeMillis()));
            organization.setStatus(Status.ACTIVE.getCode());
            organization.setIs_deleted(false);
            repository.save(organization);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateOrg(Long id, OrganizationUpdateDto organizationUpdateDto) {
        try {
            String path = FileUploadService.saveOrgImage(organizationUpdateDto.getLogo_file());
            repository.updateById(organizationUpdateDto.getName(), organizationUpdateDto.getDescription(), organizationUpdateDto.getEmail(), Instant.now(), path, id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Organization getById(Long id) {
        return repository.getById(id);
    }

    public void deleteOrg(String name) {
        Organization organization = repository.findByName(name);
        repository.delete(organization);
    }

    public List<Organization> getAll(){
        return repository.findAll();
    }

    public List<OrganizationDto> getAllAndParse(List<Organization> organizations){
        List<OrganizationDto>organizationDtos=new ArrayList<>();
        for (Organization organization : organizations) {
            String create_at = getCreateAt(organization);
            String create_by = getCreateBy(organization);
            OrganizationDto organizationDto=OrganizationDto.builder()
                    .name(organization.getName())
                    .description(organization.getDescription())
                    .email(organization.getEmail())
                    .logo_path(organization.getLogo_path())
                    .created_at(create_at)
                    .created_by(create_by)
                    .build();
            organizationDtos.add(organizationDto);
        }
        return organizationDtos;
    }

    private String getCreateBy(Organization organization) {
        String create_by = getByIdAndGetUsername(organization.getCreated_by());
        return create_by;
    }

    private String getCreateAt(Organization organization) {
        String create_at = organization.getCreated_at().toString().substring(0, 10);
        return create_at;
    }

    public String getByIdAndGetUsername(Long id) {
        return authUserRepository.getById(id).getUsername();
    }

    public OrganizationDto getByName(String name) {
        Organization organization = repository.findByName(name);
        OrganizationDto organizationDto = mapper.toDto(organization);
        organizationDto.setCreated_at(getCreateAt(organization));
        organizationDto.setCreated_by(getCreateBy(organization));
        return organizationDto;
    }




}
