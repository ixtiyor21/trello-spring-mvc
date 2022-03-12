package uz.ixtiyor21.trello_magic.dto.projectMember;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProjectMemberDto {
    private Long project_id;
    private Long user_id;
    private String created_at;
    private String created_by;
}
