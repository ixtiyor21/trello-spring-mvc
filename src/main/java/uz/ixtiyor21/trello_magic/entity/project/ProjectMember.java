package uz.ixtiyor21.trello_magic.entity.project;

import lombok.*;
import uz.ixtiyor21.trello_magic.entity.Auditable;
import uz.ixtiyor21.trello_magic.entity.auth.AuthUser;

import javax.persistence.*;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 06.03.2022 8:37
 * Project : Trello_magic
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "project_member")
public class ProjectMember extends Auditable{
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AuthUser authUser;
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean is_lead;
}
