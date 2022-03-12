package uz.ixtiyor21.trello_magic.service.projectColumn;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import uz.ixtiyor21.trello_magic.entity.project.Project;
import uz.ixtiyor21.trello_magic.entity.project.ProjectColumn;
import uz.ixtiyor21.trello_magic.mapper.projectColumn.ProjectColumnMapper;
import uz.ixtiyor21.trello_magic.repository.project.ProjectColumnRepository;
import uz.ixtiyor21.trello_magic.service.AbstractService;
import uz.ixtiyor21.trello_magic.utils.BaseUtils;
import uz.ixtiyor21.trello_magic.validator.projectColumn.ProjectColumnValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 9:42
 * Project : Trello_magic
 */
@Service
public class ProjectColumnService extends AbstractService<ProjectColumnRepository, ProjectColumnMapper, ProjectColumnValidator> {

    protected ProjectColumnService(ProjectColumnRepository repository, ProjectColumnMapper mapper, ProjectColumnValidator validator, BaseUtils baseUtils) {
        super(repository, mapper, validator, baseUtils);
    }

    public List<ProjectColumn> getColumnByProjectId(Long id) {
        List<ProjectColumn> projectColumns = new ArrayList<>();
        List<ProjectColumn> all = repository.findAll();
        for (ProjectColumn projectColumn : all) {
            if (projectColumn.getProject().getId().equals(id)) {
                projectColumns.add(projectColumn);
            }
        }
        return projectColumns;
    }

    public ProjectColumn getById(Long id){
        return repository.getById(id);
    }

    public void save(ProjectColumn projectColumn1) {
        repository.save(projectColumn1);
    }
}
