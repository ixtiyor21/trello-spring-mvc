package uz.ixtiyor21.trello_magic.service.project;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import uz.ixtiyor21.trello_magic.config.Session;
import uz.ixtiyor21.trello_magic.dto.project.ProjectCreateDto;
import uz.ixtiyor21.trello_magic.dto.project.ProjectDto;
import uz.ixtiyor21.trello_magic.dto.project.ProjectUpdateDto;
import uz.ixtiyor21.trello_magic.dto.projectMember.ProjectMemberDto;
import uz.ixtiyor21.trello_magic.entity.project.Project;
import uz.ixtiyor21.trello_magic.entity.project.ProjectColumn;
import uz.ixtiyor21.trello_magic.entity.project.ProjectMember;
import uz.ixtiyor21.trello_magic.mapper.project.ProjectMapper;
import uz.ixtiyor21.trello_magic.repository.project.ProjectRepository;
import uz.ixtiyor21.trello_magic.repository.project_member.ProjectMemberRepository;
import uz.ixtiyor21.trello_magic.service.AbstractService;
import uz.ixtiyor21.trello_magic.service.BaseService;
import uz.ixtiyor21.trello_magic.service.auth.AuthUserService;
import uz.ixtiyor21.trello_magic.service.organization.OrganizationService;
import uz.ixtiyor21.trello_magic.service.projectColumn.ProjectColumnService;
import uz.ixtiyor21.trello_magic.utils.BaseUtils;
import uz.ixtiyor21.trello_magic.validator.project.ProjectValidator;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 9:42
 * Project : Trello_magic
 */
@Service
public class ProjectService extends AbstractService<ProjectRepository, ProjectMapper, ProjectValidator> implements BaseService {

    private final AuthUserService authUserService;
    private final OrganizationService organizationService;
    private final ProjectColumnService projectColumnService;
    private final ProjectMemberRepository projectMemberRepository;


    protected ProjectService(ProjectRepository repository, ProjectMapper mapper, ProjectValidator validator, BaseUtils baseUtils, AuthUserService authUserService, OrganizationService organizationService, ProjectColumnService projectColumnService, ProjectMemberRepository projectMemberRepository) {
        super(repository, mapper, validator, baseUtils);
        this.authUserService = authUserService;
        this.organizationService = organizationService;
        this.projectColumnService = projectColumnService;
        this.projectMemberRepository = projectMemberRepository;
    }

    public List<ProjectDto> getProjectsByUserIdWithProjectMembers(Long id) {
        List<ProjectDto> projects = new ArrayList<>();
        List<ProjectMember> projectMembers = projectMemberRepository.findAll();
        for (ProjectMember projectMember : projectMembers) {
            if (projectMember.getAuthUser().getId().equals(id)) {
                ProjectDto projectDto = mapper.toDto(projectMember.getProject());
                projectDto.setCreated_at(getByDataString(projectMember.getProject().getCreated_at()));
                projectDto.setCreated_by(authUserService.getUsernameById(projectMember.getProject().getCreated_by()));
                projects.add(projectDto);
            }
        }
        return projects;
    }

    public void update(Long id, ProjectUpdateDto projectUpdateDto) {
        repository.updateById(projectUpdateDto.getName(), Boolean.parseBoolean(projectUpdateDto.getClosed()),
                Instant.now(), Session.getSession().getId(), id);
    }

    public void delete(Long id) {
        repository.delete(repository.getById(id));
    }

    public void create(ProjectCreateDto projectCreateDto) {
        Project project = mapper.fromCreateDto(projectCreateDto);
        project.setOrganization(organizationService.getById(projectCreateDto.getOrganization()));
        project.setClosed(false);
        project.setCode(String.valueOf(System.currentTimeMillis()));
        project.setCreated_at(Instant.now());
        project.setCreated_by(Session.getSession().getId());
        project.setIs_deleted(false);

        ProjectColumn projectColumn1 = new ProjectColumn();
        projectColumn1.setProject(project);
        projectColumn1.setCreated_by(Session.getSession().getId());
        projectColumn1.setActive(true);
        projectColumn1.setName("Todo");
        projectColumn1.setIs_deleted(false);
        projectColumn1.setCode(String.valueOf(System.currentTimeMillis()));
        projectColumn1.setCreated_at(Instant.now());

        ProjectColumn projectColumn2 = new ProjectColumn();
        projectColumn2.setProject(project);
        projectColumn2.setCreated_by(Session.getSession().getId());
        projectColumn2.setActive(true);
        projectColumn2.setName("In Progress");
        projectColumn2.setIs_deleted(false);
        projectColumn2.setCode(String.valueOf(System.currentTimeMillis()));
        projectColumn2.setCreated_at(Instant.now());

        ProjectColumn projectColumn3 = new ProjectColumn();
        projectColumn3.setProject(project);
        projectColumn3.setCreated_by(Session.getSession().getId());
        projectColumn3.setActive(true);
        projectColumn3.setName("Review");
        projectColumn3.setIs_deleted(false);
        projectColumn3.setCode(String.valueOf(System.currentTimeMillis()));
        projectColumn3.setCreated_at(Instant.now());

        ProjectColumn projectColumn4 = new ProjectColumn();
        projectColumn4.setProject(project);
        projectColumn4.setCreated_by(Session.getSession().getId());
        projectColumn4.setActive(true);
        projectColumn4.setName("Done");
        projectColumn4.setIs_deleted(false);
        projectColumn4.setCode(String.valueOf(System.currentTimeMillis()));
        projectColumn4.setCreated_at(Instant.now());

        repository.save(project);
        projectColumnService.save(projectColumn1);
        projectColumnService.save(projectColumn2);
        projectColumnService.save(projectColumn3);
        projectColumnService.save(projectColumn4);
    }

    public ProjectDto getById(Long id) {
        Project project = repository.getById(id);
        String byDataString = getByDataString(project.getCreated_at());
        String byUsernameWithId = authUserService.getUsernameById(project.getCreated_by());
        ProjectDto projectDto = mapper.toDto(project);
        projectDto.setCreated_at(byDataString);
        projectDto.setCreated_by(byUsernameWithId);
        return projectDto;
    }

    public Project getProjectById(Long id) {
        return repository.getById(id);
    }

    public List<Project> getAll(){
        return repository.findAll();
    }

    public List<ProjectDto> getAllByOrgId(Long id) {
        List<ProjectDto> projectDtos=new ArrayList<>();
        List<Project>projects=getAll();
        for (Project project : projects) {
            if(project.getOrganization().getId().equals(id)){
                String byDataString = getByDataString(project.getCreated_at());
                String byUsernameWithId = authUserService.getUsernameById(project.getCreated_by());
                ProjectDto projectDto=mapper.toDto(project);
                projectDto.setCreated_at(byDataString);
                projectDto.setCreated_by(byUsernameWithId);
                projectDtos.add(projectDto);
            }
        }
        return projectDtos;
    }

        public String getByDataString(Instant instant) {
        return String.valueOf(instant).substring(0, 10);
    }


}
