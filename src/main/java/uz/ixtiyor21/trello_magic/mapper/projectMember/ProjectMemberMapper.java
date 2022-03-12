package uz.ixtiyor21.trello_magic.mapper.projectMember;

import org.springframework.stereotype.Component;
import uz.ixtiyor21.trello_magic.dto.projectMember.ProjectMemberCreateDto;
import uz.ixtiyor21.trello_magic.dto.projectMember.ProjectMemberDto;
import uz.ixtiyor21.trello_magic.dto.projectMember.ProjectMemberUpdateDto;
import uz.ixtiyor21.trello_magic.entity.project.ProjectMember;
import uz.ixtiyor21.trello_magic.mapper.BaseMapper;

import java.util.List;

@Component
public class ProjectMemberMapper implements BaseMapper<ProjectMember, ProjectMemberDto, ProjectMemberCreateDto, ProjectMemberUpdateDto> {
    @Override
    public ProjectMemberDto toDto(ProjectMember projectMember) {
        return null;
    }

    @Override
    public List<ProjectMemberDto> toDto(List<ProjectMember> e) {
        return null;
    }

    @Override
    public ProjectMember fromCreateDto(ProjectMemberCreateDto projectMemberCreateDto) {
        return ProjectMember.builder()
                .build();
    }

    @Override
    public ProjectMember fromUpdateDto(ProjectMemberUpdateDto projectMemberUpdateDto) {
        return null;
    }
}
