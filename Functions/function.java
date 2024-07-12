import java.util.*;
    //function Decleration
public class function {
    public static void printMyName(String name) {  //Parameters or formal parameters
        System.out.println("You Entered "+name);
        return;
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            String name = sc.next();
            //function call
            printMyName(name); //arguents or actual parameters
        }
    }
}