package OOPs;

public class Copyconstructor {
    public static void main(String args[]){
        Student s1 = new Student();
        s1.name = "pratham";
        s1.Rollno = 0152;
        s1.password = "xyz";
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;

        Student s2 = new Student(s1);
        s2.password = "abcd";
        s1.marks[2] = 100;
        for(int i=0; i<3; i++){
            System.out.println(s2.marks[i]+" ");
        }
    }
}

class Student {
    String name;
    int Rollno;
    String password;
    int marks[];
    Student() {
        marks = new int[3];
        System.out.println("This is default constructor.");
    }

    // Copy constructor

    // or Shallow constructor
    // When we call Shallow constructor then 
    // its change value is reflect in o/p
    
    Student(Student s1){
        System.out.println("This is copy constructor.");
        marks = new int[3];
        this.marks = s1.marks;
        this.name = s1.name;
        this.Rollno = s1.Rollno;
        this.password = s1.password;
    }
    
    // //Deep copy constructor
    // When we call Deep constructor then 
    // its change value is not  reflect in o/p

    // Student(Student s1){
    //     marks = new int[3];
    //     this.name = s1.name;
    //     this.Rollno = s1.Rollno;
    //     for(int i=0; i<marks.length; i++){
    //         this.marks[i] = s1.marks[i];
    //     }
    // }

    Student(String name) {
        marks = new int[3];
        this.name = name;
    }

    Student(int Rollno) {
        marks = new int[3];
        this.Rollno = Rollno;
    }
}
