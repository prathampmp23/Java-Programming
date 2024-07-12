package BasicPrograms;
import java.util.*;
class Triangle
{
    public static void main(String[] args)
    {
        int Base,Height;
        float Area;
        Scanner s = new Scanner(System.in);
            System.out.println("Enter the Base");
            Base = s.nextInt();
            System.out.println("Enter the Height");
            Height = s.nextInt();
        s.close();
        Area = 0.5f * Base * Height;
        System.out.println("Area of triangle is :" +Area);
    }
}