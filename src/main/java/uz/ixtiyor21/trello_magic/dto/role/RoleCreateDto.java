package uz.ixtiyor21.trello_magic.dto.role;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RoleCreateDto {
    private String code;
    private String name;
}
