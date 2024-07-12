package OOPs;

public class Hierachial {
    public static void main(String args[]){
        Birds b1 = new Birds();
        b1.eat();
        b1.breathe();
        b1.Fly();
    }
}
class ANIMAL {
    String colour;
    void eat() {
        System.out.println("Eats");
    }
    void breathe() {
        System.out.println("Breathe");
    }
}
class Mammel extends ANIMAL {
    int legs;
    void walks() {
        System.out.println("Swims in water");
    }
}
class Fishs extends ANIMAL {
    void Swim() {
        System.out.println("Swims in water");
    }
}
class Birds extends ANIMAL {
    void Fly() {
        System.out.println("Fly in sky");
    }
}
