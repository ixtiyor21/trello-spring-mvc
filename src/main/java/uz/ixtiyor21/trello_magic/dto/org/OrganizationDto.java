package uz.ixtiyor21.trello_magic.dto.org;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 11:18
 * Project : Trello_magic
 */
@Getter
@Setter
@Builder
public class OrganizationDto {
    private Long id;
    private String name;
    private String description;
    private String logo_path;
    private String email;
    private String created_by;
    private String created_at;
}
