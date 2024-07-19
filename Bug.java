// import java.util.*;

// public class Bug {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String st  = new String();
//         st = sc.nextLine();
//         int count = 1;
//         System.out.println("1"+" "+st);
        
//         while(sc.hasNext()){
//             System.out.println(count+" "+sc.nextLine());
//             count++;
//         }
//         sc.close();
//     }
// }
import java.util.Scanner;

public class Bug {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineNumber = 1; // Initialize line number

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(lineNumber + " " + line);
            lineNumber++;
        }

        scanner.close(); // Close the scanner
    }
}
