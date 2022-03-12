package uz.ixtiyor21.trello_magic.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskStatusUpdateDto {
    private Long task_id;
    private Long column_id;
}
