package com.hibernatecodes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// import jakarta.persistence.Transient;
// import jakarta.persistence.Column;

@Entity
@Table(name = "student_table") // this create new table 
public class Student {

    @Id // anotation for primary key
    private int id;
    // @Transient // if we dont want to store name (temporary values)
    // @Column(name = "new_name") // to set new name to column
    // private String name;

    // Use of Embeddable Object
    private EmbeddedName name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    public EmbeddedName getName() {
        return name;
    }

    public void setName(EmbeddedName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }
}
