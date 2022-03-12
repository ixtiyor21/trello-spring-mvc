package uz.ixtiyor21.trello_magic.entity.project;

import lombok.*;
import uz.ixtiyor21.trello_magic.entity.Auditable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 06.03.2022 8:36
 * Project : Trello_magic
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "project_column")
public class ProjectColumn extends Auditable {
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    private String code;
    private String name;
    private Boolean active;
}
