package uz.ixtiyor21.trello_magic.dto.taskMember;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskMemberCreateDto {
    private Long project_id;
    private Long user_id;
    private Boolean is_lead;
}
