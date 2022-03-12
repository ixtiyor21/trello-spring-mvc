package uz.ixtiyor21.trello_magic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 05.03.2022 22:28
 * Project : Trello_magic
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    public static final String[] WHITE_LIST = {
            "/no","/auth/login",
    };

    public static final String[] WHITE_LIST_RESOURCES = {
            "/image/**", "/css/**","/webjars/**","/js/**","/error"
    };

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public SecurityConfigurer(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(expressionInterceptUrlRegistry ->
                        expressionInterceptUrlRegistry
                                .antMatchers(WHITE_LIST).permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .formLogin(httpSecurityFormLoginConfigurer ->
                        httpSecurityFormLoginConfigurer
                                .permitAll()
                                .loginPage("/auth/login")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/",true)
                )
                .rememberMe(httpSecurityRememberMeConfigurer -> {
                            httpSecurityRememberMeConfigurer
                                    .key("fabufybg&^R%R&^R%FTGU^%DU*&I*YHFT^$S&^%T#%&^")
                                    .rememberMeParameter("remember-me")
                                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(40));
                        })
                .logout(httpSecurityLogoutConfigurer ->
                        httpSecurityLogoutConfigurer
                                .logoutUrl("/auth/logout")
                                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout","POST"))
                                .invalidateHttpSession(true)
                                .clearAuthentication(true)
                                .deleteCookies("JSESSIONID","remember-me")
                );
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(WHITE_LIST_RESOURCES);
    }
}
