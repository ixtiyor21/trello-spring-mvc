package uz.ixtiyor21.trello_magic.service.projectMember;

import org.springframework.stereotype.Service;
import uz.ixtiyor21.trello_magic.config.Session;
import uz.ixtiyor21.trello_magic.dto.projectMember.ProjectMemberCreateDto;
import uz.ixtiyor21.trello_magic.entity.auth.AuthUser;
import uz.ixtiyor21.trello_magic.entity.project.Project;
import uz.ixtiyor21.trello_magic.entity.project.ProjectMember;
import uz.ixtiyor21.trello_magic.mapper.projectMember.ProjectMemberMapper;
import uz.ixtiyor21.trello_magic.repository.project_member.ProjectMemberRepository;
import uz.ixtiyor21.trello_magic.service.AbstractService;
import uz.ixtiyor21.trello_magic.service.BaseService;
import uz.ixtiyor21.trello_magic.service.auth.AuthUserService;
import uz.ixtiyor21.trello_magic.service.project.ProjectService;
import uz.ixtiyor21.trello_magic.utils.BaseUtils;
import uz.ixtiyor21.trello_magic.validator.projectMember.ProjectMemberValidator;

import java.time.Instant;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 9:42
 * Project : Trello_magic
 */
@Service
public class ProjectMemberService extends AbstractService<ProjectMemberRepository, ProjectMemberMapper, ProjectMemberValidator>implements BaseService {

    private final ProjectService projectService;
    private final AuthUserService authUserService;

    protected ProjectMemberService(ProjectMemberRepository repository, ProjectMemberMapper mapper, ProjectMemberValidator validator, BaseUtils baseUtils, ProjectService projectService, AuthUserService authUserService) {
        super(repository, mapper, validator, baseUtils);
        this.projectService = projectService;
        this.authUserService = authUserService;
    }

    public void create(ProjectMemberCreateDto projectMemberCreateDto){
        Project project=projectService.getProjectById(projectMemberCreateDto.getProject_id());
        AuthUser authUser=authUserService.getById(projectMemberCreateDto.getUser_id());
        ProjectMember projectMember=ProjectMember.builder()
                .project(project)
                .authUser(authUser)
                .is_lead(projectMemberCreateDto.getIs_lead())
                .build();
        projectMember.setCreated_at(Instant.now());
        projectMember.setCreated_by(Session.getSession().getId());
        projectMember.setIs_deleted(false);
        repository.save(projectMember);

    }


}
