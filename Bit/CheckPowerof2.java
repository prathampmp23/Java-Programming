package Bit;

public class CheckPowerof2 {
    public static boolean IsPowerofTwo(int n){
        //to check 2^n is two power or not
        return (n&(n-1)) == 0;
    }
    public static void main(String args[]){
        System.out.println(IsPowerofTwo(8));
        System.out.println(IsPowerofTwo(10));
        System.out.println(IsPowerofTwo(16));
    }
}
