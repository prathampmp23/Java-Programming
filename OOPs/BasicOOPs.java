package OOPs;
public class BasicOOPs {
    public static void main(String args[]) {
        Pen p = new Pen();
        p.setcolour("Red");
        System.out.println(p.colour);
        p.settip(5);
        System.out.println(p.tip);
    }
}

class Pen {
    String colour;
    int tip;

    void setcolour(String newcolour) {
        colour = newcolour;
    }

    void settip(int tipsize) {
        tip = tipsize;
    }
}
