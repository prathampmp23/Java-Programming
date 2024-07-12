package String;

public class Stringbuilder {
    public static void main(String args[]){
        StringBuilder sb = new StringBuilder("");
        for(char ch='a'; ch<='z'; ch++){
        //append() is used to joint element at last part to string
            sb.append(ch);
        }
        //its code complexity is O(26)
        System.out.println(sb);
        System.out.println(sb.length());
    }
}
