package com.example.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "persons", type = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Id
    private String id;
    @Field(name = "name", type = FieldType.Text)
    private String name;
    @Field(name = "last_name", type = FieldType.Text)
    private String last_name;
    @Field(name = "address", type = FieldType.Text)
    private String address;
    @Field(name = "birthday", type = FieldType.Text)
    private Date birthDay;
}
