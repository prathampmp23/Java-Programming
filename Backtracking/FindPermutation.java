package Backtracking;
//Time complexity = O(n * n!)
public class FindPermutation {
    public static void permutation(String str , String ans){
        //Base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        //Recursion
        for(int i=0; i<str.length(); i++){
            char current = str.charAt(i);
            //substring() is method to divide string into substrings 
            //here ending index is exclusive or it does not count
            String NewStr = str.substring(0,i) + str.substring(i+1);
            permutation(NewStr,ans+current);
        }
    }
    public static void main(String args[]) {
        String str = "abc";
        permutation(str,"");
    }
}
