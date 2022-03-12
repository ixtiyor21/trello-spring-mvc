package uz.ixtiyor21.trello_magic.service.auth;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.ixtiyor21.trello_magic.config.Session;
import uz.ixtiyor21.trello_magic.dto.auth.AuthUserCreateDto;
import uz.ixtiyor21.trello_magic.dto.auth.AuthUserUpdateDto;
import uz.ixtiyor21.trello_magic.entity.auth.AuthUser;
import uz.ixtiyor21.trello_magic.entity.org.Organization;
import uz.ixtiyor21.trello_magic.entity.role.Role;
import uz.ixtiyor21.trello_magic.mapper.auth.AuthUserMapper;
import uz.ixtiyor21.trello_magic.repository.auth.AuthUserRepository;
import uz.ixtiyor21.trello_magic.service.AbstractService;
import uz.ixtiyor21.trello_magic.service.BaseService;
import uz.ixtiyor21.trello_magic.service.file.FileUploadService;
import uz.ixtiyor21.trello_magic.service.organization.OrganizationService;
import uz.ixtiyor21.trello_magic.service.role.RoleService;
import uz.ixtiyor21.trello_magic.utils.BaseUtils;
import uz.ixtiyor21.trello_magic.validator.auth.AuthUserValidator;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 9:40
 * Project : Trello_magic
 */
@Service
public class AuthUserService extends AbstractService<AuthUserRepository, AuthUserMapper, AuthUserValidator> implements BaseService {

    private final OrganizationService organizationService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    protected AuthUserService(AuthUserRepository repository, AuthUserMapper mapper, AuthUserValidator validator, BaseUtils baseUtils, OrganizationService organizationService, RoleService roleService, PasswordEncoder passwordEncoder) {
        super(repository, mapper, validator, baseUtils);
        this.organizationService = organizationService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    public List<AuthUser> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.delete(repository.getById(id));
    }

    public void create(AuthUserCreateDto authUserCreateDto) {
        try {
            Organization org = organizationService.getById(authUserCreateDto.getOrganization());
            String path = FileUploadService.saveUserImage(authUserCreateDto.getImage_path());
            AuthUser authUser = mapper.fromCreateDto(authUserCreateDto);
            Role role = roleService.getByCode(authUserCreateDto.getRole());
            authUser.setPassword(passwordEncoder.encode(authUserCreateDto.getPassword()));
            authUser.setRole(role);
            authUser.setImage_path(path);
            authUser.setIs_deleted(false);
            authUser.setIs_SuperUser(false);
            authUser.setCode(String.valueOf(System.currentTimeMillis()));
            authUser.setOrganization(org);
            authUser.setCreated_at(Instant.now());
            authUser.setCreated_by(Session.getSession().getId());
            repository.save(authUser);
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AuthUser getSession() {
        return (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public void updateProfile(Long id, AuthUserUpdateDto authUserUpdateDto) {
        try {
            String path = FileUploadService.saveUserImage(authUserUpdateDto.getImagePath());
            repository.updateById(authUserUpdateDto.getFirstName(), authUserUpdateDto.getLastName(), authUserUpdateDto.getUsername(),
                    authUserUpdateDto.getEmail(), Instant.now(), Session.getSession().getId(), authUserUpdateDto.getLang(), path, id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AuthUser getById(Long id) {
        return repository.getById(id);
    }

    public String getUsernameById(Long id) {
        return repository.getById(id).getUsername();
    }

}
