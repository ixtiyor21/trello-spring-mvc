package uz.ixtiyor21.trello_magic.mapper.task;

import org.springframework.stereotype.Component;
import uz.ixtiyor21.trello_magic.dto.task.TaskCreateDto;
import uz.ixtiyor21.trello_magic.dto.task.TaskDto;
import uz.ixtiyor21.trello_magic.dto.task.TaskUpdateDto;
import uz.ixtiyor21.trello_magic.entity.task.Task;
import uz.ixtiyor21.trello_magic.mapper.BaseMapper;

import java.util.List;

@Component
public class TaskMapper implements BaseMapper<Task, TaskDto, TaskCreateDto, TaskUpdateDto> {
    @Override
    public TaskDto toDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .name(task.getName())
                .completed(task.getCompleted())
                .deadline(task.getDeadline())
                .level(task.getLevel())
                .project(task.getProject())
                .description(task.getDescription())
                .closed(task.getClosed())
                .projectColumn(task.getProjectColumn())
                .status(task.getStatus())
                .build();
    }

    @Override
    public List<TaskDto> toDto(List<Task> e) {
        return null;
    }

    @Override
    public Task fromCreateDto(TaskCreateDto taskCreateDto) {
        return Task.builder()
                .name(taskCreateDto.getName())
                .description(taskCreateDto.getDescription())
                .level(taskCreateDto.getLevel())
                .build();
    }

    @Override
    public Task fromUpdateDto(TaskUpdateDto taskUpdateDto) {
        return null;
    }
}
