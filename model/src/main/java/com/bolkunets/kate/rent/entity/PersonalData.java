package com.bolkunets.kate.rent.entity;

import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personal_data")
@Setter
@EqualsAndHashCode
public class PersonalData {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String male;
    private Timestamp birthDate; //todo to instant
    private User user;
    private List<Email> emails;
    private List<Phone> phones;
    private IdentificationData identificationData;
    private List<PersonalDataAddresses> personalDataAddresses;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    public Long getId() {
        return id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "middle_name")
    public String getMiddleName() {
        return middleName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "male")
    public String getMale() {
        return male;
    }

    @Column(name = "birth_date")
    public Timestamp getBirthDate() {
        return birthDate;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    @OneToMany(mappedBy = "personalData", orphanRemoval = true)
    public List<Email> getEmails() {
        return emails;
    }

    @OneToMany(mappedBy = "personalData", orphanRemoval = true)
    public List<Phone> getPhones() {
        return phones;
    }

    @OneToOne(mappedBy = "personalData", cascade = CascadeType.PERSIST)
    public IdentificationData getIdentificationData() {
        return identificationData;
    }

    @OneToMany(mappedBy = "personalData", orphanRemoval = true)
    public List<PersonalDataAddresses> getPersonalDataAddresses() {
        if (personalDataAddresses == null) {
            personalDataAddresses = new ArrayList<>();
        }
        return personalDataAddresses;
    }
}
