package CommandLine;
public class commandline {
    public static void main(String args[]) {
        int a,b, sum=0;
        a=Integer.parseInt(args[0]);
        b=Integer.parseInt(args[1]);
        sum =a+b;
        System.out.println("sum is "+ sum);
    }
}
