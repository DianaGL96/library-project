package ru.itgirl.library_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itgirl.library_project.model.User;
import ru.itgirl.library_project.repository.UserRepository;


@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByUserLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        //List<SimpleGrantedAuthority>authorities = Arrays.stream(user.getRoles().split(","))
                //.map(SimpleGrantedAuthority::new)
                //.collect(Collectors.toList());

        String[] authorities = user.getRoles().split(",");

        return org.springframework.security.core.userdetails.User.withUsername(user.getLogin())
        .password(user.getPassword())
        .authorities(authorities)
        .build();
    }

    public User createUser (String login, String password, String roles) {
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setRoles(roles);

        return userRepository.save(user);
    }
}
