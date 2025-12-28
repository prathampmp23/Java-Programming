package Core.JUnit_Testing;

public class MannualTestingClass {

    public static void main(String[] args) {
        // ** Mannual UnitTesting 
        Calulator c = new Calulator(); // instance
        int ans1 = c.multiply(10, 5);
        int ans2 = c.divide(10, 5);
        System.out.println(ans1);
        System.out.println(ans2);

        // test
        if (ans1 == 50)
            System.out.println("Test case is passed");
        else
            System.out.println("Test case failed!");

        if (ans2 == 2)
            System.out.println("Test case is passed");
        else
            System.out.println("Test case failed!");
    }
}