package Strings;
import java.util.Arrays;
public class Anagrams {
    public static void main(String args[]){
        String str1 = "earth";
        String str2 = "heart";

        //to convert string to lowercase
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        //first check whether its length are same or not
        if(str1.length() == str2.length()){

            //convert string to array
            char[] str1toarray = str1.toCharArray();
            char[] str2toarray = str2.toCharArray();

            //Now sort the array
            Arrays.sort(str1toarray);
            Arrays.sort(str2toarray);
            
            //Below is the array method to compare the two arrays
            boolean result = Arrays.equals(str1toarray , str2toarray);
            if(result){
                System.out.println("It is a anagrams.");
            } else {
                System.out.println("It is not a anagrams.");
            }
        } else {
            System.out.println(str1+" "+str2+" is not a anagrams of each others");
        }
    }
}
