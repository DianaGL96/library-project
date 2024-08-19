package ru.itgirl.library_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itgirl.library_project.model.MyUser;
import ru.itgirl.library_project.repository.MyUserRepository;

import java.util.List;

@Service
public class PasswordEncryptionService {

    private final MyUserRepository myUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PasswordEncryptionService(MyUserRepository myUserRepository, PasswordEncoder passwordEncoder) {
        this.myUserRepository = myUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void encryptExistingPasswords() {
        List<MyUser> users = myUserRepository.findAll();

        for (MyUser user : users) {
            String rawPassword = user.getPassword();

            if (!rawPassword.startsWith("$2a$")) {
                String encodedPassword = passwordEncoder.encode(rawPassword);
                user.setPassword(encodedPassword);
                myUserRepository.save(user);
            }
        }
    }
}
