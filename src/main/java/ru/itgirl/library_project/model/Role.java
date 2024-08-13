package ru.itgirl.library_project.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private RoleType roleType;

    //@ManyToMany(mappedBy = "roles")
    //private Set<User> users = new HashSet<>();

    public Role (RoleType roleType) {
        this.roleType = roleType;
    }

    public Role(){

    }

    public Long getId() {
        return id;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    @Override
    public String toString() {
        return "Role {" + "id: " + id + ", roleType: " + roleType + "}";
    }
}
