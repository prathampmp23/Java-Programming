package OOPs;

public class Inheritance {
    public static void main(String args[]) {
        Fish f1 = new Fish();
        f1.eat();
        f1.breathe();
        f1.swim();
    }
}
//Base class
class AnimalSpecies {
    String colour;
    void eat() {
        System.out.println("Eats");
    }
    void breathe() {
        System.out.println("Breathe");
    }
}
//Derived class
class Fish extends AnimalSpecies {
    int fins;
    void swim() {
        System.out.println("Swims in water");
    }
}
