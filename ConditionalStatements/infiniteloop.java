package ConditionalStatements;
public class infiniteloop {
    public static void main(String args[]) {
        int a =10;
        do{
            int i=1;
            System.out.print(i);
            i++;
        }while(a>=10);
    }
}
