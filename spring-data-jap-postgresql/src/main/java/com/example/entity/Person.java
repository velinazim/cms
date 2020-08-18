package com.example.entity;

import lombok.*;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Person {
    @Id
    @SequenceGenerator(name = "seq_person", allocationSize = 1)
    @GeneratedValue(generator = "seq_person")
    private long id;

    @Column(length = 100, name = "name")
    private String name;

    @Column(length = 100, name = "last_name")
    private String last_name;

    @OneToMany
    @JoinColumn(name = "person_address_id")
    private List<Address> addresses;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
