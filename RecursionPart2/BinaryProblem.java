package RecursionPart2;
public class BinaryProblem {
    public static void PrintbinaryString(int n , int lastno , String str){
        //Base case
        if(n == 0){
            System.out.println(str);
            return;
        }
        PrintbinaryString(n-1, 0, str+"0");
        if(lastno == 0){
            PrintbinaryString(n-1, 1, str+"1");
        }
    }
    public static void main(String args[]){
        PrintbinaryString(4,0,"");
    }
}
