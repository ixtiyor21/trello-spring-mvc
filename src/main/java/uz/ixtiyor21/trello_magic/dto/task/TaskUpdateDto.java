package uz.ixtiyor21.trello_magic.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class TaskUpdateDto {
    private Long projectColumn_id;
    private String name;
    private String status;
    private Date deadline;
    private String level;
    private Boolean completed;
}
