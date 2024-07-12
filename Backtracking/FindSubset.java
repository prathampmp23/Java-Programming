package Backtracking;

public class FindSubset {
    public static void findSubset(String str, String ans , int index) {
        //Base case
        if(index == str.length()){
            if(ans.length() == 0){
                System.out.println("Null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        //for yes choice
        findSubset(str, ans+str.charAt(index), index+1);
        //for no choice
        findSubset(str, ans, index+1);
    }
    public static void main(String args[]) {
        String str = "abc";
        findSubset(str,"",0);
    }
}
