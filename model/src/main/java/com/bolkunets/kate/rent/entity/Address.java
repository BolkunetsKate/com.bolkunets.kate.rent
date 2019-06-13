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
@Table(name = "addresses")
@Setter
@EqualsAndHashCode
public class Address {
    private Long id;
    private String country;
    private String region;
    private String area;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer flatNumber;
    private Boolean isPrimary;
    private List<PersonalDataAddresses> personalDataAddresses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    public Long getId() {
        return id;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    @Column(name = "area")
    public String getArea() {
        return area;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    @Column(name = "house_number")
    public Integer getHouseNumber() {
        return houseNumber;
    }

    @Column(name = "flat_number")
    public Integer getFlatNumber() {
        return flatNumber;
    }

    @Column(name = "is_primary")
    public Boolean getPrimary() {
        return isPrimary;
    }


    @OneToMany(mappedBy = "address", orphanRemoval = true)
    public List<PersonalDataAddresses> getPersonalDataAddresses() {
        if (personalDataAddresses == null) {
            personalDataAddresses = new ArrayList<>();
        }
        return personalDataAddresses;
    }
}
