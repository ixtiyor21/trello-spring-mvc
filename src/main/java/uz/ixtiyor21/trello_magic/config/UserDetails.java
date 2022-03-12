package uz.ixtiyor21.trello_magic.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import uz.ixtiyor21.trello_magic.entity.auth.AuthUser;
import uz.ixtiyor21.trello_magic.entity.role.Role;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 05.03.2022 22:52
 * Project : Trello_magic
 */
@Getter
@Setter
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private Long id;
    private String role_code;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String image_path;
    private Boolean isSuper;
    private Role role;
    private Long organization_id;
    private Set<GrantedAuthority> authorities;

    public UserDetails(AuthUser authUser) {
        this.id = authUser.getId();
        this.role_code = authUser.getRole().getCode();
        this.username = authUser.getUsername();
        this.firstName = authUser.getFirstName();
        this.lastName = authUser.getLastName();
        this.password = authUser.getPassword();
        this.email = authUser.getEmail();
        this.image_path = authUser.getImage_path();
        this.isSuper = authUser.getIs_SuperUser();
        this.role = authUser.getRole();
        this.organization_id = authUser.getOrganization().getId();
    }

    public UserDetails(){
    }

    private void processAuthorities(AuthUser user){
        authorities=new HashSet<>();
        Role role=user.getRole();

        if (Objects.isNull(role))return;
        authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getCode()));
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
