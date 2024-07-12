package BasicPrograms;
import java.util.*;
public class table {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
            int num;
            System.out.println("Enter the number to print it's table");
            num = s.nextInt();
            s.close();
            for(int i =1;i<=10;i++)
            {
                System.out.println(num+" * "+i+" = "+(num*i));
            }
        }   
    }
        


