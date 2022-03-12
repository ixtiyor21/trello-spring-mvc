package uz.ixtiyor21.trello_magic.dto.org;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 11:26
 * Project : Trello_magic
 */
@Getter
@Setter
@Builder
public class OrganizationCreateDto {
    private String name;
    private String description;
    private MultipartFile logo_file;
    private String email;
}
