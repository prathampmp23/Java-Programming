package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class BeautifulArray {
    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(1);

        while(ans.size() < n) {
            ArrayList<Integer> temp = new ArrayList<Integer>();

            for(int i=0; i< ans.size(); i++){
                if((ans.get(i)*2 - 1) <= n) {
                    temp.add(ans.get(i)*2 - 1);
                }
            }
            for(int i=0; i< ans.size(); i++){
                if((ans.get(i)*2) <= n) {
                    temp.add(ans.get(i)*2);
                }
            }
            ans = temp;
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of Array :");
        int n = sc.nextInt();
        ArrayList<Integer> arr = beautifulArray(n);

        for(int i=0; i<arr.size(); i++) {
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
        sc.close();
    }
}
