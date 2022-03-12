package uz.ixtiyor21.trello_magic.entity.org;

import lombok.*;
import uz.ixtiyor21.trello_magic.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 05.03.2022 23:12
 * Project : Trello_magic
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "organization")
public class Organization extends Auditable {
    private String name;
    @Column(unique = true, nullable = false)
    private String code;
    private String status;
    private String description;
    private String logo_path;
    @Column(unique = true)
    private String email;
}
