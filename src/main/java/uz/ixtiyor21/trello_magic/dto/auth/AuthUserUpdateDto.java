package uz.ixtiyor21.trello_magic.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.ixtiyor21.trello_magic.entity.role.Role;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 10:00
 * Project : Trello_magic
 */
@Getter
@Setter
@Builder
public class AuthUserUpdateDto{
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private MultipartFile imagePath;
    private String lang;
}
