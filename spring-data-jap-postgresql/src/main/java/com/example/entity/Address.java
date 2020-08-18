package com.example.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_address")
@EqualsAndHashCode(of = "id")
@ToString
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_person_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_person_address")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AddressType getAdressType() {
        return adressType;
    }

    public void setAdressType(AddressType addressType) {
        this.adressType = addressType;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Column(length = 500, name = "Address")
    private String address;

    @Enumerated
    private AddressType adressType;

    @Column(name = "Status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "person_address_id")
    private Person person;

    public Address() {
    }

    public enum AddressType{
        HOME_ADDRESS,
        JOB_ADDRESS,
        OTHER
    }
}
