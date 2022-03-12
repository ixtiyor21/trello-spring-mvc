package uz.ixtiyor21.trello_magic.entity.task;

import lombok.*;
import uz.ixtiyor21.trello_magic.entity.Auditable;
import uz.ixtiyor21.trello_magic.entity.project.Project;
import uz.ixtiyor21.trello_magic.entity.project.ProjectColumn;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 06.03.2022 8:40
 * Project : Trello_magic
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "task")
public class Task extends Auditable {
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "column_id")
    private ProjectColumn projectColumn;
    private String name;
    private String status;
    private Date deadline;
    private String level;
    private String description;
    private Boolean closed;
    private Boolean completed;

}
