package StringPrograms;

public class Substring {
    public static String Printsubstring(String str, int si , int ei){
        String substring = "";
        for(int i=si; i<ei; i++){
          substring += str.charAt(i);
        }
        return substring;
    }
    public static void main(String args[]){
       String str = "HelloWorld";
       System.out.println(Printsubstring(str,0,5));

       //This is also done by substring() method
       System.out.println(str.substring(0,4));
    }
}
