public class OOPs {
    public static void main(String[] args) {
        // OOPs concepts
        Dog D1 = new Dog();
        D1.name = "Tommy";
        D1.bark();

        Dog D2 = new Dog();
        D2.name = "Leo";
        D2.walk();

        Complex c1 = new Complex();
        c1.a = 5;
        c1.b = 3;
        c1.print();

        Greet g1 = new Greet();
        g1.greet();
        g1.greet("Pratham");
        g1.greet("Pratham", "Hi");
    }
}

class Dog {
    String name;
    int age;
    String color;

    void bark() {
        System.out.println(name+" is Barking");
    }

    void walk() {
        System.out.println(name+" is Walking");
    }
}

class Cat {
    String name;
    int age;
    String color;

    void meow() {
        System.out.println("Cat is Meowing");
    }

    void walk() {
        System.out.println("Cat is Walking");
    }
}

class Complex {
    int a,b;

    void print() {
        System.out.println(a+" + "+b+"i");
    }
}

class Greet {
    // Method Overloading
    void greet() {
        System.out.println("Hello");
    }
    void greet(String name) {
        System.out.println("Hello "+name);
    }
    void greet(String name, String greet) {
        System.out.println(greet+" "+name);
    }
}