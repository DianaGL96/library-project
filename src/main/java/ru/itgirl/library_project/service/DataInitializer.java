package ru.itgirl.library_project.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final PasswordEncryptionService passwordEncryptionService;

    @Autowired
    public DataInitializer(PasswordEncryptionService passwordEncryptionService) {
        this.passwordEncryptionService = passwordEncryptionService;
    }

    @PostConstruct
    public void init() {
        passwordEncryptionService.encryptExistingPasswords();
    }
}
