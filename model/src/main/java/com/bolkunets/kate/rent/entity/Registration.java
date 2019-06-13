package com.bolkunets.kate.rent.entity;

import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "registrations")
@Setter
@EqualsAndHashCode
public class Registration {
    private Long id;
    private String email;
    private String code;
    private Short registrationAttempts;
    private Timestamp lastAttemptDate; // todo to instant

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    public Long getId() {
        return id;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Column(name = "code")
    public String getCode() {
        return code;
    }

    @Column(name = "registration_attempts")
    public Short getRegistrationAttempts() {
        return registrationAttempts;
    }

    @Column(name = "last_attempt_date")
    public Timestamp getLastAttemptDate() {
        return lastAttemptDate;
    }
}
