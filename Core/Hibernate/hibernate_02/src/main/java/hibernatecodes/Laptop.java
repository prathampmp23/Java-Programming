package hibernatecodes;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "laptop_table") // this create new table
public class Laptop {

    @Id // anotation for primary key
    private int id;
    private String name;

    @OneToOne // one student have one laptop
    private Student student;

    // @ManyToOne // many student have one laptop
    // private Student student;

    // @ManyToMany // many student have many laptops
    // private List<Student> student = new ArrayList<Student>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // oneToOne
    public Student getStu() {
        return student;
    }

    public void setStu(Student student) {
        this.student = student;
    }

    // ManyToMany
    // public List<Student> getStudent() {
    //     return student;
    // }

    // public void setStudent(List<Student> student) {
    //     this.student = student;
    // }

}
