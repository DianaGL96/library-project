package ru.itgirl.library_project.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_role",
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", table = "role"),//, referencedColumnName = "id", table = "users"
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", table = "users")//, referencedColumnName = "id", table = "role")
    )
    private Set<Role>roles = new HashSet<>();

    public User(){

    }

    public User (String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
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

    public Set<Role> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "User {"+ "id: " + id + ", login: " + login + ", password: " + password + ", roles: " + roles + " }";
    }


}


