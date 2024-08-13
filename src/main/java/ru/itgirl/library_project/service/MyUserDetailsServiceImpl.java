package ru.itgirl.library_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itgirl.library_project.model.MyUser;
import ru.itgirl.library_project.repository.MyUserRepository;


@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private final MyUserRepository userRepository;

    @Autowired
    public MyUserDetailsServiceImpl(MyUserRepository userRepository){
        this.userRepository = userRepository;
    }

    //@Bean
    //public BCryptPasswordEncoder passwordEncoder() {
        //return new BCryptPasswordEncoder();
    //}

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        MyUser user = userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return MyUserDetailsImpl.build(user);

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
