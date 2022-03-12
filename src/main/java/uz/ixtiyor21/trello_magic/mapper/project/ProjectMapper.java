package uz.ixtiyor21.trello_magic.mapper.project;

import org.springframework.stereotype.Component;
import uz.ixtiyor21.trello_magic.dto.project.ProjectCreateDto;
import uz.ixtiyor21.trello_magic.dto.project.ProjectDto;
import uz.ixtiyor21.trello_magic.dto.project.ProjectUpdateDto;
import uz.ixtiyor21.trello_magic.entity.project.Project;
import uz.ixtiyor21.trello_magic.mapper.BaseMapper;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 11:58
 * Project : Trello_magic
 */
@Component
public class ProjectMapper implements BaseMapper<Project, ProjectDto, ProjectCreateDto, ProjectUpdateDto> {
    @Override
    public ProjectDto toDto(Project project) {
        return ProjectDto.builder()
                .id(project.getId())
                .name(project.getName())
                .organization(project.getOrganization())
                .closed(project.getClosed())
                .code(project.getCode())
                .build();
    }

    @Override
    public List<ProjectDto> toDto(List<Project> e) {
        return null;
    }

    @Override
    public Project fromCreateDto(ProjectCreateDto projectCreateDto) {
        return Project.builder()
                .name(projectCreateDto.getName())
                .build();
    }

    @Override
    public Project fromUpdateDto(ProjectUpdateDto projectUpdateDto) {
        return null;
    }
}
