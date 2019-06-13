package com.bolkunets.kate.rent.entity;

import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "identification_data")
@Setter
@EqualsAndHashCode
public class IdentificationData {
    private Long id;
    private String number;
    private Instant issueDate;
    private String issuingAuthority;
    private Type type;
    private PersonalData personalData;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    public Long getId() {
        return id;
    }

    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    @Column(name = "issue_date")
    public Instant getIssueDate() {
        return issueDate;
    }

    @Column(name = "issuing_authority")
    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    @Column(name = "type")
    public Type getType() {
        return type;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_data_id")
    public PersonalData getPersonalData() {
        return personalData;
    }

    public enum Type {
        PASSPORT, DRIVER_LICENSE, STUDENT_ID
    }
}
