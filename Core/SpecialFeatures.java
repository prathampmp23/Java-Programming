package Core;

public class SpecialFeatures {
    // ** LYTI -
    // class var {} // not possible as no className should be var

    // ** Sealed class -
    // sealed class A permits C, D {}
    // class B extends A {} // not possible as B is not have permit 
    // final class C extends A {}
    // final class D extends A {}

    // permit should be written in last
    // sealed class A extends Thread implements Clonable permits C, D {} 

    public static void main(String[] args) {

        // LVTI (Local variable type interface) -
        // int a = 10;
        // var b = 12;
        // int c;
        // var d; // not possible as var need initialization
        // String var = "Pratham";
        // int nums1[] = new int[10];
        // var nums2 = new int[10];

        // var nums3[] = new int[10]; // not possible
        // var obj = new ClassName();

        // Sealed class - restrict which class can extends and implements

    }
}
