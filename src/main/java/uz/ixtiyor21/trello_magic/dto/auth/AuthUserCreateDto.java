package uz.ixtiyor21.trello_magic.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 10:00
 * Project : Trello_magic
 */
@Getter
@Setter
@Builder
public class AuthUserCreateDto {
    private Long organization;
    private String role;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private MultipartFile image_path;
    private String lang;
}
