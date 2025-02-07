package Z_Practice;

public class OOPsI {

    public static void main(String args[]) {
        // Object (creation)
        Pen p1 = new Pen();
        p1.setColor("red");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());

        Student s1 = new Student();
        s1.rollNo = 136;
        s1.name = "Pratham";
        s1.password = "abcd";
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;

        Student s2 = new Student(s1);
        // to copy all s1 properties and set new password
        s2.password = "xyz";
        // this make change in value as object is copy by copy constructor and s1 is
        // pointing to array
        // reason behind it is as array is pass by reference then s2 is pointing toward
        // same array
        s1.marks[2] = 90;
        for (int i = 0; i < 3; i++) {
            System.out.println(s2.marks[i]);
        }

        // Inheritance
        Fish shark = new Fish();
        shark.eat();
        shark.swim();

        // Polymorphism
        // method overloading
        Calculator c1 = new Calculator();
        System.out.println(c1.sum(2, 3));
        System.out.println(c1.sum((float) 2.5, (float) 3.6));
        System.out.println(c1.sum(2, 3, 8));

        // method overriding
        Deer d1 = new Deer();
        d1.eat();

        // Abstraction

        Horse h1 = new Horse();
        h1.eat();
        h1.walk();
        // use of constructor
        System.out.println(h1.color);
        h1.changeColor();
        System.out.println(h1.color);

        Chicken g1 = new Chicken();
        g1.eat();
        g1.walk();
        System.out.println(g1.color);
        g1.changeColor();
        System.out.println(g1.color);

        // Interface
        Queen q1 = new Queen();
        q1.moves();
        King k1 = new King();
        k1.moves();
    }
}

class Student {
    int rollNo;
    String name;
    String password;
    int marks[];

    // 1. Non Parameterized constructor
    Student() {
        System.out.println("Non Parameterized constructor");
        marks = new int[3];
    }

    // 2. Parameterized constructor
    Student(String name) {
        this.name = name;
        marks = new int[3];
    }

    // 3. copy constructor

    // shallow copy constructor (reflect changes)
    // Student(Student s1) {
    // // to copy s1 properties
    // this.rollNo = s1.rollNo;
    // this.name = s1.name;
    // marks = new int[3];
    // this.marks = s1.marks; // pass references
    // }

    // Deep copy constructor (not reflect changes)
    Student(Student s1) {
        // to copy s1 properties
        this.rollNo = s1.rollNo;
        this.name = s1.name;
        marks = new int[3];
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = s1.marks[i];
        }
    }
}

// classes
class Pen {
    private String color;
    private int tip;

    // Constructor
    Pen() {
        System.out.println("Constructor is called ...");
    }

    // ** Getters ** //
    String getColor() {
        return this.color;
    }

    int getTip() {
        return this.tip;
    }

    // ** Setters ** //
    void setColor(String color) {
        this.color = color;
    }

    void setTip(int tip) {
        this.tip = tip;
    }
}

// Inheritance
// Base class / parent
class Animal {
    int color;

    void eat() {
        System.out.println("eats");
    }

    void breath() {
        System.out.println("breaths");
    }
}

// Derived class / child
class Fish extends Animal {
    int fins;

    void swim() {
        System.out.println("Swim");
    }
}

// Polymorphism
class Calculator {
    // Method overloading
    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}

class Deer extends Animal {
    // Method overriding
    void eat() {
        System.out.println("Eats grass");
    }
}

// Abstraction

// ** abstract class
abstract class Animals {
    String color;

    // constructor
    Animals() {
        // to initialize variable for child class
        color = "brown";
    }

    void eat() {
        System.out.println("Eats");
    }

    // ** abstract method
    // provide idea to implement method in extended class
    abstract void walk();
}

class Horse extends Animals {
    void changeColor() {
        color = "dark brown";
    }

    // actual implemented in derived classes
    void walk() {
        System.out.println("Walkes on 4 legs");
    }
}

class Chicken extends Animals {
    void changeColor() {
        color = "Yellow";
    }

    // actual implemented in derived classes
    void walk() {
        System.out.println("Walkes on 2 legs");
    }
}

// Interface
interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer {
    public void moves() {
        System.out.println("up down left right diagonal (in all direction)");
    }
}

class Rook implements ChessPlayer {
    public void moves() {
        System.out.println("up down left right diagonal");
    }
}

class King implements ChessPlayer {
    public void moves() {
        System.out.println("up down left right diagonal (by one moves)");
    }
}