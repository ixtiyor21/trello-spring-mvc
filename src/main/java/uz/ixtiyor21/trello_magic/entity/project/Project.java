package uz.ixtiyor21.trello_magic.entity.project;

import lombok.*;
import uz.ixtiyor21.trello_magic.entity.Auditable;
import uz.ixtiyor21.trello_magic.entity.org.Organization;

import javax.persistence.*;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 05.03.2022 23:19
 * Project : Trello_magic
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "project")
public class Project extends Auditable {
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
    @Column(unique = true)
    private String code;
    private String name;
    private Boolean closed;
}
