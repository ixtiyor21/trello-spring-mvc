package uz.ixtiyor21.trello_magic.dto.taskMember;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.ixtiyor21.trello_magic.entity.auth.AuthUser;
import uz.ixtiyor21.trello_magic.entity.project.Project;

@Getter
@Setter
@Builder
public class TaskMemberDto {
    private Project project;
    private AuthUser user;
    private Boolean is_lead;
}
