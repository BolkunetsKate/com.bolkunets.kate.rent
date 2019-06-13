package com.bolkunets.kate.rent.entity;

import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Setter
@EqualsAndHashCode
public class User {
    private Long id;
    private String username;
    private String passwordHash;
    private PersonalData personalData;
    private List<UserRole> usersRoles;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    public Long getId() {
        return id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    @Column(name = "password_hash")
    public String getPasswordHash() {
        return passwordHash;
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST)
    public PersonalData getPersonalData() {
        return personalData;
    }

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    public List<UserRole> getUsersRoles() {
        if (usersRoles == null) {
            usersRoles = new ArrayList<>();
        }
        return usersRoles;
    }
}
