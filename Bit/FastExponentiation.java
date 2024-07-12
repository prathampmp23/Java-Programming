package Bit;

public class FastExponentiation {
    public static int fastExponentiation(int a , int n){
        // it is in the form of a^n
        // it is best method to find out power of any number 
        // its time complexity is log(n)
        int ans = 1;
        while(n > 0){
            if((n & 1) != 0){ // check LSB
                ans = ans * a;
            }
            a = a * a;
            n = n>>1;
        }
        return ans;
    }
    public static void main(String args[]){
        System.out.println(fastExponentiation(5,2));
    }
}
