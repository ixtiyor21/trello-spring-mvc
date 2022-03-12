package uz.ixtiyor21.trello_magic.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskLevelUpdateDto {
    private Long task_id;
    private String level;
}
