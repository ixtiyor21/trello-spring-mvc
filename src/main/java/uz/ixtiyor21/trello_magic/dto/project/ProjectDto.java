package uz.ixtiyor21.trello_magic.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.ixtiyor21.trello_magic.entity.org.Organization;


@Getter
@Setter
@Builder
public class ProjectDto {
    private Long id;
    private Organization organization;
    private String code;
    private String name;
    private Boolean closed;
    private String created_by;
    private String created_at;
}
