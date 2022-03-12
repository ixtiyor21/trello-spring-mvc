package uz.ixtiyor21.trello_magic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 05.03.2022 23:07
 * Project : Trello_magic
 */
@Getter
@Setter
@MappedSuperclass
public class Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean is_deleted;
    private Long created_by;
    @Column(name = "created_at")
    private Instant created_at;
    private Long updated_by;
    @Column(name = "updated_at")
    private Instant updated_at;
}