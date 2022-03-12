package uz.ixtiyor21.trello_magic.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.ixtiyor21.trello_magic.entity.role.Role;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 9:59
 * Project : Trello_magic
 */
@Getter
@Setter
@Builder

public class AuthUserDto {
    private String organization;
    private String firstName;
    private String lastName;
    private String username;
    private String code;
    private String password;
    private String email;
    private Boolean isSuperUser;
    private Boolean session;
    private String imagePath;
    private Role role;
    private String lang;
}
