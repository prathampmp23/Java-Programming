package OOPs;

public class Multilevel {
    public static void main(String args[]){
        Dog don = new Dog();
        don.eat();
        don.legs = 4;
        System.out.println(don.legs);
    }
}
//Base class
class Animals {
    String colour;
    void eat() {
        System.out.println("Eats");
    }
    void breathe() {
        System.out.println("Breathe");
    }
}
class Mammels extends Animals {
    int legs;
    void walks() {
        System.out.println("Swims in water");
    }
}
class Dog extends Mammels {
    String breed;
}