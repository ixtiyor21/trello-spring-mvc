package uz.ixtiyor21.trello_magic.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProjectUpdateDto {
    private Long id;
    private String name;
    private String closed;
}
