package Arrays;
import java.util.*;

public class StockArray {
    public static int Stock(int price[]){
        int buyPrice = Integer.MAX_VALUE;  
        // Intege.MAX_VALUE is to find minimum value
        // (+)infinity to check min value
        int Maxprofit = 0;
        for(int i=0; i<price.length; i++){
            if(buyPrice < price[i]){
                int profit = price[i] - buyPrice;
                Maxprofit = Math.max(Maxprofit,profit);
            } else{
                buyPrice = price[i];
            }
        }
        return Maxprofit;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size :");
        int size = sc.nextInt();
        System.out.println("Enter the element in an array:");
        int price[] = new int[size];
        for(int i=0;i<price.length;i++){
            price[i] = sc.nextInt();
        }
        sc.close();
        System.out.println("maximum profit ="+ Stock(price));;
}
}
