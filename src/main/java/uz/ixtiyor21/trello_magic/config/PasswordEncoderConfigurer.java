package uz.ixtiyor21.trello_magic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 05.03.2022 22:27
 * Project : Trello_magic
 */

@Configuration
public class PasswordEncoderConfigurer {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

}
