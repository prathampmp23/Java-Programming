package Strings;
import java.util.*;
public class palindrome1 {

    public static boolean Palindrome(int n){
        int num = n;
        int reverse = 0;
        while(n>0){
            int remainder = n % 10;
            reverse = reverse * 10 + remainder;
            n = n/10;
        }
        if(num == reverse){
            return true;
        }
        return false;
    }

    public static boolean isPalindrome(String str){
        for(int i=0; i< str.length()/2; i++){
            int n = str.length();
            //not a palindrome
            if(str.charAt(i) != str.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        sc.close();
        // if(Palindrome(n)){
        //     System.out.println("Number is Palindrome");
        // } else {
        //     System.out.println("Number is not palindrome");
        // }
        String str = "racecar";
        System.out.println(isPalindrome(str));
    }
    
}