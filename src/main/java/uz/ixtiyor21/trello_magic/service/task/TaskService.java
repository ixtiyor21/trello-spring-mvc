package uz.ixtiyor21.trello_magic.service.task;

import org.springframework.stereotype.Service;
import uz.ixtiyor21.trello_magic.config.Session;
import uz.ixtiyor21.trello_magic.dto.task.TaskCreateDto;
import uz.ixtiyor21.trello_magic.dto.task.TaskDto;
import uz.ixtiyor21.trello_magic.entity.project.Project;
import uz.ixtiyor21.trello_magic.entity.project.ProjectColumn;
import uz.ixtiyor21.trello_magic.entity.task.Task;
import uz.ixtiyor21.trello_magic.enums.status.Status;
import uz.ixtiyor21.trello_magic.mapper.task.TaskMapper;
import uz.ixtiyor21.trello_magic.repository.task.TaskRepository;
import uz.ixtiyor21.trello_magic.service.AbstractService;
import uz.ixtiyor21.trello_magic.service.BaseService;
import uz.ixtiyor21.trello_magic.service.auth.AuthUserService;
import uz.ixtiyor21.trello_magic.service.project.ProjectService;
import uz.ixtiyor21.trello_magic.service.projectColumn.ProjectColumnService;
import uz.ixtiyor21.trello_magic.utils.BaseUtils;
import uz.ixtiyor21.trello_magic.validator.task.TaskValidator;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 9:43
 * Project : Trello_magic
 */
@Service
public class TaskService extends AbstractService<TaskRepository, TaskMapper, TaskValidator> implements BaseService {

    private final ProjectService projectService;
    private final ProjectColumnService projectColumnService;
    private final AuthUserService authUserService;


    protected TaskService(TaskRepository repository, TaskMapper mapper, TaskValidator validator, BaseUtils baseUtils, ProjectService projectService, ProjectColumnService projectColumnService, AuthUserService authUserService) {
        super(repository, mapper, validator, baseUtils);
        this.projectService = projectService;
        this.projectColumnService = projectColumnService;
        this.authUserService = authUserService;
    }

    public void updateColumnId(Long task_id, Long column_id) {
        repository.updateColumn(column_id, Instant.now(), Session.getSession().getId(), task_id);
    }

    public void updateLevel(Long task_id, String level) {
        repository.updateLevel(level, Instant.now(), Session.getSession().getId(), task_id);
    }

    public void delete(Long id) {
        repository.delete(repository.getById(id));
    }

    public void updateClosed(Long id) {
    }

    public Integer getCountClosedTasksList(List<Task> tasks) {
        Integer count = 0;
        for (Task task : tasks) {
            if (task.getClosed()) {
                count++;
            }
        }
        return count;
    }

    public Integer getCountCompletedTasksList(List<Task> tasks) {
        Integer count = 0;
        for (Task task : tasks) {
            if (task.getCompleted()) {
                count++;
            }
        }
        return count;
    }

    public List<Task> getAll() {
        return repository.findAll();
    }

    public TaskDto getTask(Long id) {
        Task task = repository.getById(id);
        TaskDto taskDto = mapper.toDto(task);
        String username = authUserService.getById(task.getCreated_by()).getUsername();
        taskDto.setCreated_at(projectService.getByDataString(task.getCreated_at()));
        taskDto.setCreated_by(username);
        return taskDto;
    }

    public void create(TaskCreateDto taskCreateDto) {
        Project project = projectService.getProjectById(taskCreateDto.getProject_id());
        ProjectColumn projectColumn = projectColumnService.getById(taskCreateDto.getProjectColumn_id());
        Task task = mapper.fromCreateDto(taskCreateDto);
        task.setCompleted(false);
        task.setClosed(false);
        task.setStatus(Status.ACTIVE.getCode());
        task.setCreated_at(Instant.now());
        task.setCreated_by(Session.getSession().getId());
        task.setProject(project);
        task.setProjectColumn(projectColumn);
        repository.save(task);
    }

    public List<Task> getAllByProjectId(Long id) {
        List<Task> taskList = new ArrayList<>();
        List<Task> tasks = getAll();
        for (Task task : tasks) {
            if (task.getProject().getId().equals(id)) {
                taskList.add(task);
            }
        }
    return taskList;
    }
}







