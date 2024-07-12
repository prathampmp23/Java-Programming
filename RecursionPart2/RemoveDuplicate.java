package RecursionPart2;
public class RemoveDuplicate {
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]){
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if(map[currChar-'a'] == true){
            removeDuplicates(str, idx+1, newStr, map);
        } else{
            map[currChar-'a'] = true;
            removeDuplicates(str, idx+1, newStr.append(currChar), map); 
            // append used is to join element in end of string
        }
    }
    public static void main(String args[]){
        String str = "appnncollege";
        removeDuplicates(str,0, new StringBuilder(""), new boolean[26]);

    }
}
