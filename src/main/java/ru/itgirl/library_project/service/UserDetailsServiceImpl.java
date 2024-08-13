package ru.itgirl.library_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itgirl.library_project.model.Role;
import ru.itgirl.library_project.model.User;
import ru.itgirl.library_project.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //@Bean
    //public BCryptPasswordEncoder passwordEncoder() {
        //return new BCryptPasswordEncoder();
    //}

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return UserDetailsImpl.build(user);

        //List<SimpleGrantedAuthority>authorities = Arrays.stream(user.getRoles().split(","))
                //.map(SimpleGrantedAuthority::new)
                //.collect(Collectors.toList());

        //String[] roles = user.getRoles().split(",");
        //List<SimpleGrantedAuthority> authorities = Arrays.stream(roles)
                //.map(role -> new SimpleGrantedAuthority(role))
                //.collect(Collectors.toList());

        //return org.springframework.security.core.userdetails.User.withUsername(user.getLogin())
        //.password(user.getPassword())
        //.authorities(authorities)
        //.build();
    }


    //public User createUser (String login, String password, String roles) {
        //String encodedPassword = passwordEncoder.encode(password);
        //User user = new User();
        //user.setLogin(login);
        //user.setPassword(encodedPassword);
        //user.setRoles(roles);

    //return userRepository.save(user);
    //}
}
