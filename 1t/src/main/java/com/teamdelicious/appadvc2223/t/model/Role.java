package com.teamdelicious.appadvc2223.t.model;



import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;


@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private Collection<User> users;

    public Role() {};

    public Role(String name) { this.name = name; };

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoleName(String roleName) { this.name = roleName; }

    public Collection<User> getUsers() { return users; }

    public void setUsers(Collection<User> users) { this.users = users;}


}
