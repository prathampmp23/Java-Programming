package Strings;

import java.util.*;

public class palindrome {
    public static void main(String args[]) {
        String s = new String();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        s = sc.next();
        sc.close();
        int i, j, flag = 0;
        i = 0;
        j = s.length() - 1;
        while (i < j && flag == 0) {
            if (s.charAt(i) != s.charAt(j)) {
                flag = 1;
            }
            i++;
            j--;
        }
        if (flag == 0) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is not palindrome");
        }

    }
}