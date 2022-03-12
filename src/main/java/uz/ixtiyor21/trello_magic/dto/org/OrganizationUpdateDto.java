package uz.ixtiyor21.trello_magic.dto.org;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 11:27
 * Project : Trello_magic
 */
@Getter
@Setter
@Builder
public class OrganizationUpdateDto {
    private Long id;
    private String name;
    private String description;
    private MultipartFile logo_file;
    private String email;
    private Instant updated_at;
    private Long updated_by;
}
