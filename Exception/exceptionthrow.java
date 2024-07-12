package Exception;
public class exceptionthrow {
    int age;
    static void show(int age) 
    {
    if(age>=18) 
    {
        throw new ArithmeticException("Access Denied");
    }
    else
    {
        System.out.println("Access granted");
    }
    }
    public static void main(String args[]) {
        show(15);
    }
}