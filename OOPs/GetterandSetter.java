package OOPs;

public class GetterandSetter {
    public static void main(String args[]) {
        //create pen class object as P
        Pens p = new Pens();
        p.setcolour("Red");
        System.out.println(p.getcolour());
        p.settip(5);
        System.out.println(p.gettip());
        p.setcolour("Green");
        System.out.println(p.getcolour());
    }
}
class Pens {
     String colour;
     int tip;
    //Getters
    String getcolour() {
        return this.colour;
    }
    //Setters
    void setcolour(String newcolour) {
        this.colour = newcolour;
    }
    //Getters
    int gettip() {
        return this.tip;
    }
    //Setters
    void settip(int tip) {
        this.tip = tip;
    }
}
