package uz.ixtiyor21.trello_magic.dto.projectMember;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProjectMemberUpdateDto {
    private Long id;
    private Long project_id;
    private Long user_id;
}
