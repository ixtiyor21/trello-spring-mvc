package uz.ixtiyor21.trello_magic.dto.projectColumn;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.ixtiyor21.trello_magic.entity.project.Project;

@Getter
@Setter
@Builder
public class ProjectColumnDto {
    private Project project;
    private String code;
    private String name;
    private Boolean active;
    private String created_by;
    private String created_at;
}
