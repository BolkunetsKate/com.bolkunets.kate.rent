package com.bolkunets.kate.rent.entity;

import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Setter
@EqualsAndHashCode
public class Role {
    private Long id;
    private RoleName name;
    private List<UserRole> usersRoles;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    public Long getId() {
        return id;
    }

    @Column(name = "name")
    public RoleName getName() {
        return name;
    }

    @OneToMany(mappedBy = "role", orphanRemoval = true)
    public List<UserRole> getUsersRoles() {
        if (usersRoles == null) {
            usersRoles = new ArrayList<>();
        }
        return usersRoles;
    }

    public enum RoleName {
        USER, ADMIN
    }
}
