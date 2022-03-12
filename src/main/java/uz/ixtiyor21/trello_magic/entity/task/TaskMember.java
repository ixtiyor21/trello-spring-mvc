package uz.ixtiyor21.trello_magic.entity.task;

import lombok.*;
import uz.ixtiyor21.trello_magic.entity.Auditable;
import uz.ixtiyor21.trello_magic.entity.auth.AuthUser;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 06.03.2022 8:49
 * Project : Trello_magic
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "task_member")
public class TaskMember extends Auditable {
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AuthUser authUser;
}
