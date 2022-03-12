package uz.ixtiyor21.trello_magic.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import uz.ixtiyor21.trello_magic.entity.auth.AuthUser;
import uz.ixtiyor21.trello_magic.repository.auth.AuthUserRepository;

import java.util.Objects;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 05.03.2022 22:59
 * Project : Trello_magic
 */
@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final AuthUserRepository authUserRepository;

    public UserDetailsService(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser user = authUserRepository.findAuthUserByUsername(username);
        if (Objects.isNull(user)) throw new UsernameNotFoundException("User not found");
        Session.setSession(user);
        return new uz.ixtiyor21.trello_magic.config.UserDetails(user);
    }
}
