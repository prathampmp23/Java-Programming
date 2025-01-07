package Arrays1D;
import java.util.*;

public class LinearSearch {

    public static int linearSearch(int num[] , int x) {
        for(int i=0;i<num.length;i++){
            if(num[i] == x){
                return i;
            } 
        }
        return -1;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size ");
        int size = sc.nextInt();
        int num[] = new int[size];
        for(int i=0;i<num.length;i++){
            System.out.println("Enter the element in Array at index :"+ i);
            num[i]=sc.nextInt();
        }
        System.out.println("Enter the element to search :");
        int x = sc.nextInt();
        sc.close();
        int Search = linearSearch(num,x);
        if( Search == -1){
            System.out.println("Number is  not found");
        } else{
            System.out.println("Number is found at index :" + Search);
        }

    }

}
