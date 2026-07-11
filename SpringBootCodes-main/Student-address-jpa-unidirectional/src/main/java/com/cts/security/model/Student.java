package com.cts.security.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ui_student")
public class Student {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
 
    private String name;
 
//    Owning side
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
 
    public int getStudentId() {
        return studentId;
    }
 
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public Address getAddress() {
        return address;
    }
 
    public void setAddress(Address address) {
        this.address = address;
    }
}
