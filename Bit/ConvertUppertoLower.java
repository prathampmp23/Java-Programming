package Bit;

public class ConvertUppertoLower {
    public static void main(String args[]){
        // Convert upper case to lower case
        for(char ch = 'A'; ch <='Z'; ch++){
            System.out.print((char)(ch | ' '));
        }
    }
}