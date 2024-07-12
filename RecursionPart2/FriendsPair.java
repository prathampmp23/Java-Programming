package RecursionPart2;
public class FriendsPair {
    public static int friendsPair(int n){
        // Base case
        if(n == 1 || n == 2){
            return n;
        }
        return friendsPair(n-1) + (n-1) * friendsPair(n-2);
    }
    public static void main(String args[]){
        System.out.println(friendsPair(3));
    }
}
