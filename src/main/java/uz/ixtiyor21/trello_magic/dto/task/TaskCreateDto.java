package uz.ixtiyor21.trello_magic.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskCreateDto {
    private Long project_id;
    private Long projectColumn_id;
    private String name;
    private String deadline;
    private String level;
    private String description;
}
