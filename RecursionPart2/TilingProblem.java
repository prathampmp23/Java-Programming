package RecursionPart2;
public class TilingProblem {
    public static int tilingProblem(int n){
        //for 2 * n floor size
        //also same for 4 * n floor size
        if(n == 0 || n == 1){
            return 1;
        }
        //vertical Choice
        int Nm1 = tilingProblem(n-1);
        //horizontal Choice
        int Nm2 = tilingProblem(n-2);

        int toWays = Nm1 + Nm2;
        return toWays;
        //return tilingProblem(n-1) + tilingProblem(n-2);
    }
    public static void main(String args[]){
        System.out.println(tilingProblem(2));
    }
}
