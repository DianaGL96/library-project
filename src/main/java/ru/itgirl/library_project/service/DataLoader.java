package ru.itgirl.library_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final UserServiceImpl userService;

    @Autowired
    public DataLoader(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void run(String... args) throws Exception {
        userService.createUser("Inga", "password1", "ROLE_USER");
        userService.createUser("Diana", "adminpassword", "ROLE_ADMIN");
        userService.createUser("Ars", "password2", "ROLE_USER,ROLE_ADMIN");
        userService.createUser("Ruslan", "password3", "ROLE_USER");
        userService.createUser("Kira", "password4", "ROLE_USER");

    }

}
