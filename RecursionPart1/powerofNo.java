public class powerofNo {
    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        return x * power(x,n-1);
    }
    public static int Optimizedpower(int x, int n){
        //It has complexity of logn
        if(n == 0){
            return 1;
        }
        int halfpower = Optimizedpower(x,n/2);
        //if it is Even
        int halfpowerSq = halfpower * halfpower;
        //if it is odd
        if(n % 2 != 0){
            halfpowerSq = x * halfpowerSq;
        }
        return halfpowerSq;

    }
    public static void main(String args[]){
        //  Give input in the form of x^n
        System.out.println(Optimizedpower(2,10));
    }
}
