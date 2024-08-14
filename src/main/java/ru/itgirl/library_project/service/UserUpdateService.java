package ru.itgirl.library_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itgirl.library_project.model.MyUser;
import ru.itgirl.library_project.repository.MyUserRepository;

import java.util.List;

//@Service
//public class UserUpdateService {

    //private final MyUserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;

    //@Autowired
    //public UserUpdateService(MyUserRepository userRepository, PasswordEncoder passwordEncoder) {
        //this.userRepository = userRepository;
        //this.passwordEncoder = passwordEncoder;
    //}

    //public void encryptExistingPasswords() {
        //List<MyUser> users = userRepository.findAll();
        //for (MyUser user : users) {
            //String encryptedPassword = passwordEncoder.encode(user.getPassword());
            //user.setPassword(encryptedPassword);
            //userRepository.save(user);
        //}
    //}
//}
