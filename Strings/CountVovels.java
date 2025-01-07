package Strings;

import java.util.Scanner;

public class CountVovels {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String str = new String("");
        System.out.println("Enter the string :");
        str = s.nextLine();
        s.close();
        int count = 0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }
        }
        System.out.println("Count of Vovels in string is :"+count);
    }
}
