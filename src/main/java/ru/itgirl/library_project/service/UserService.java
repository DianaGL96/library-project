package ru.itgirl.library_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itgirl.library_project.model.MyUser;
import ru.itgirl.library_project.model.Role;
import ru.itgirl.library_project.repository.MyUserRepository;

import java.util.Set;

@Service
public class UserService {

    private final MyUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(MyUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public MyUser createUser(String login, String rawPassword, Set<Role> roles) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        MyUser user = new MyUser();
        user.setLogin(login);
        user.setPassword(encodedPassword);
        user.setRoles(roles);

        return userRepository.save(user);
    }
}
