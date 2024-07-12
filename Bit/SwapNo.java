package Bit;

public class SwapNo {
    public static void main(String args[]){
        // Swaping two number without using three variable
        int x=3, y=4;
        System.out.println("Before swap value : "+"X ="+x+" Y ="+y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("After swap value : "+"X ="+x+" Y ="+y);
    }
}
