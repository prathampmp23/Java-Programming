package StringPrograms;

public class CompareString {
    public static void main(String args[]){
        String A = "Pratham";
        String B = "Pratham";
        String C = new String("Pratham");
        if(A == B){
            System.out.println("String are same");
        } else{
            System.out.println("String are not same");
        }

        // this gives wrong output
        if(A == C){
            System.out.println("String are same");
        } else{
            System.out.println("String are not same");
        }

        //this can be avoided 
        //by using equals() method
        if(A.equals(C)){
            System.out.println("String are same");
        } else{
            System.out.println("String are not same");
        }

    }
}
