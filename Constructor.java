public class Constructor {
    public static void main(String args[]) {
        ComplexNum c1 = new ComplexNum(2, 3);
        ComplexNum c2 = new ComplexNum(5, 9);
        c1.Print();
        c2.Print();
        System.out.println("Adding two complex number");
        ComplexNum result = c1.add(c2);
        result.Print();
    }
}

class ComplexNum {
    int a, b;

    public ComplexNum(int real, int imaginary) {
        a = real;
        b = imaginary;
    }

    void Print() {
        System.out.println(a + " + " + b + "i");
    }

    ComplexNum add(ComplexNum num) {
        return new ComplexNum(a + num.a, b + num.b);
    }
}
