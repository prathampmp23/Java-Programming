package Arrays;
import java.util.Scanner;
public class ReverseArray {

    public static void reverse(int num[]){
        int first = 0 , last = num.length-1;
        while(first < last){
            int temp = num[last];
            num[last] = num[first];
            num[first] = temp;
            first++;
            last--;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size ");
        int size = sc.nextInt();
        int num[] = new int[size];
        System.out.println("Enter the element in Array :");
        for(int i=0;i<num.length;i++){
            num[i]=sc.nextInt();
        }
        sc.close();
        reverse(num);
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }
}
