package Backtracking;

public class Keypadnumber {
    //Time complexity = 4^n
    final static char[][] Letters = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},
                                    {'j','k','l'},{'m','n','o'},{'p','q','r','s'},
                                    {'t','u','v'},{'w','x','y','z'}};

    public static void letterCombinations(String GivenString) {
        int length = GivenString.length();
        if (length == 0) {
            System.out.println("");
        return;
        }
        RecursiveFun(0, length, new StringBuilder(), GivenString);
    }
    
    public static void RecursiveFun(int position, int length, StringBuilder outputString, String GivenString) {
        if (position == length){
            System.out.print(outputString.toString()+" ");
        } else {
            char[] letters = Letters[Character.getNumericValue(GivenString.charAt(position))];
            for (int i = 0; i < letters.length; i++){
            RecursiveFun(position+1, length, new StringBuilder(outputString).append(letters[i]), GivenString);
        }
    }
}
    public static void main(String args[]){
        letterCombinations("23");
    }
}
