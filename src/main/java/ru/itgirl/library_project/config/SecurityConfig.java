package ru.itgirl.library_project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.itgirl.library_project.model.RoleType;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    private DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }


    @Bean
    public AuthenticationManager authorizationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.authenticationProvider(authenticationProvider());
        httpSecurity.authorizeHttpRequests(authorization -> authorization
                        .requestMatchers("/book").hasAnyAuthority(RoleType.USER.name())
                        .requestMatchers("/books").hasAnyAuthority(RoleType.ADMIN.name())
                        .requestMatchers("/book/v2").hasAnyAuthority(RoleType.ADMIN.name())
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }


    //@Bean
    //public UserDetailsService users () {
        //User.UserBuilder users = User.withDefaultPasswordEncoder();
        //UserDetails user = users
                //.username("user")
                //.password("password")
                //.roles("USER")
                //.build();
        //UserDetails admin = users
                //.username("admin")
                //.password("password")
                //.roles("USER", "ADMIN")
                //.build();
        //return new InMemoryUserDetailsManager(user, admin);

    //}
}
