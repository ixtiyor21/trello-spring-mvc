package uz.ixtiyor21.trello_magic.entity.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.ixtiyor21.trello_magic.entity.Auditable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 05.03.2022 22:54
 * Project : Trello_magic
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role extends Auditable {
    private String code;
    private String name;

}
