package ArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lonelynum {
    public static ArrayList<Integer> Findlonely(ArrayList<Integer> num) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = num.size();
        //sort array
        Collections.sort(num);

        for(int i=0; i<n; i++){
            //to check left element with current element
            if(i != 0 && (num.get(i - 1) == (num.get(i) - 1) || num.get(i-1) == num.get(i))) {
                continue; // this return to for loop again not execute below conditions
            }
            //to check right element with current element
            if(i != n-1 && (num.get(i + 1) == num.get(i) + 1 || num.get(i+1) == num.get(i) )) {
                continue;
            }
            result.add(num.get(i));
        }
        return result;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the size of Array :");
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            int num = sc.nextInt();
            arr.add(num);
        }
        sc.close();

        ArrayList<Integer> Ans = Findlonely(arr);
        System.out.println("Lonely number are :"+ Ans);
    }
}
