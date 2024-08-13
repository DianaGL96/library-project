package ru.itgirl.library_project.model;

import jakarta.persistence.*;
import lombok.*;

//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Getter
@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column(name = "login")
    //@Setter
    private String login;

    @Column(name = "password")
    //@Setter
    private String password;

    @Column(name = "roles")
    //@Setter
    private String roles;

    public User(){

    }

    public User (String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User {"+ "id: " + id + ", login: " + login + ", password: " + password + ", roles: " + roles + " }";
    }


}


