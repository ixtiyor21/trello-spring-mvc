package uz.ixtiyor21.trello_magic.mapper.projectColumn;

import org.springframework.stereotype.Component;
import uz.ixtiyor21.trello_magic.dto.projectColumn.ProjectColumnCreateDto;
import uz.ixtiyor21.trello_magic.dto.projectColumn.ProjectColumnDto;
import uz.ixtiyor21.trello_magic.dto.projectColumn.ProjectColumnUpdateDto;
import uz.ixtiyor21.trello_magic.entity.project.ProjectColumn;
import uz.ixtiyor21.trello_magic.mapper.BaseMapper;

import java.util.List;

@Component
public class ProjectColumnMapper implements BaseMapper<ProjectColumn, ProjectColumnDto, ProjectColumnCreateDto, ProjectColumnUpdateDto> {

    @Override
    public ProjectColumnDto toDto(ProjectColumn projectColumn) {
        return null;
    }

    @Override
    public List<ProjectColumnDto> toDto(List<ProjectColumn> e) {
        return null;
    }

    @Override
    public ProjectColumn fromCreateDto(ProjectColumnCreateDto projectColumnCreateDto) {
        return null;
    }

    @Override
    public ProjectColumn fromUpdateDto(ProjectColumnUpdateDto projectColumnUpdateDto) {
        return null;
    }
}
