package ru.itmentor.spring.boot_security.demo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> roles;

    public Role() {
    }

    public Role(String name, Set<User> roles) {
        this.name = name;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getRoles() {
        return roles;
    }

    public void setRoles(Set<User> roles) {
        this.roles = roles;
    }
}
