package uz.ixtiyor21.trello_magic.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.ixtiyor21.trello_magic.entity.project.Project;
import uz.ixtiyor21.trello_magic.entity.project.ProjectColumn;

import java.util.Date;


@Getter
@Setter
@Builder
public class TaskDto {
    private Long id;
    private Project project;
    private ProjectColumn projectColumn;
    private String name;
    private String status;
    private Date deadline;
    private String level;
    private String description;
    private Boolean closed;
    private Boolean completed;
    private String created_by;
    private String created_at;
}
