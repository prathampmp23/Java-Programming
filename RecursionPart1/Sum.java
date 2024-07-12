public class Sum {
    public static int SumOfNum(int n){
        //To calculate sum of N natural numbers
        if(n == 1){
            return 1;
        }
        int sm1 = SumOfNum(n-1);
        int sN = n + sm1;
        return sN;
    }
    public static void main(String args[]){
        int n = 5;
        System.out.println(SumOfNum(n));
    }
}
