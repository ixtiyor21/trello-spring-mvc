package uz.ixtiyor21.trello_magic.entity.auth;

import lombok.*;
import uz.ixtiyor21.trello_magic.entity.Auditable;
import uz.ixtiyor21.trello_magic.entity.org.Organization;
import uz.ixtiyor21.trello_magic.entity.role.Role;

import javax.persistence.*;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 05.03.2022 22:51
 * Project : Trello_magic
 */


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="auth_user")
public class AuthUser extends Auditable {
    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organization organization;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String code;
    private String password;
    @Column(unique = true)
    private String email;
    @Column(name = "is_super_user")
    private Boolean is_SuperUser;
    private Boolean session;
    private String image_path;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    private String lang;
}