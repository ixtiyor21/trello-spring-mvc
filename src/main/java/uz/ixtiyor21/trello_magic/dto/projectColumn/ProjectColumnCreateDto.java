package uz.ixtiyor21.trello_magic.dto.projectColumn;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProjectColumnCreateDto {
    private Long project;
    private String name;
}
