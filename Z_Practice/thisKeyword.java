package Z_Practice;
public class thisKeyword {
    public static void main(String args[]) {
        ComplexNumber num1 = new ComplexNumber(2, 3);
        ComplexNumber num2 = new ComplexNumber(5, 9);
        num1.Print();
        num2.Print();
        System.out.println("Adding two complex number");
        ComplexNumber result = num1.add(num2);
        System.out.println(num1);
        result.Print();
    }
}

class ComplexNumber {
    int a, b;

    public ComplexNumber(int a, int b) {
        // to access current object (a and b), we use this keyword
        this.a = a;
        this.b = b;
    }

    void Print() {
        System.out.println(a + " + " + b + "i");
    }

    ComplexNumber add(ComplexNumber num2) {
        this.Print();
        System.out.println(this);
        num2.Print();
        return new ComplexNumber(a + num2.a, b + num2.b);
    }
}
