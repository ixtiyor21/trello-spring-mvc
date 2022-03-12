package uz.ixtiyor21.trello_magic.entity.task;

import lombok.Getter;
import lombok.Setter;
import uz.ixtiyor21.trello_magic.entity.Auditable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 06.03.2022 8:47
 * Project : Trello_magic
 */
@Getter
@Setter
@Entity
@Table(name = "task_comment")
public class TaskComment extends Auditable {
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
    private String comment;
}
