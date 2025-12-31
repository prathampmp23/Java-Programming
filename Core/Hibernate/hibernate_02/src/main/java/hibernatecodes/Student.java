package hibernatecodes;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_table") // this create new table
public class Student {

    @Id
    private int id;
    private String name;
    private int marks;
    // Mapping relationship btw student and laptop

    @OneToOne // one student only have one laptop
    private Laptop laptop;

    // @OneToMany(mappedBy = "student") // one student only have many laptop
    // (mappedBy = "stu") this will stop creating multiple table for relation this make 3 instead of 4 table
    // private List<Laptop> laptop = new ArrayList<Laptop>();

    // @ManyToMany(mappedBy = "student") // many student have many laptop
    // private List<Laptop> laptop = new ArrayList<Laptop>();

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

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    // OneToOne 
    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    // manyToMany
    // public List<Laptop> getLaptop() {
    //     return laptop;
    // }

    // public void setLaptop(List<Laptop> laptop) {
    //     this.laptop = laptop;
    // }

}
