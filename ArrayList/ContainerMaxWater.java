package ArrayList;
import java.util.ArrayList;

public class ContainerMaxWater {

        //Brute force approach - O(n^2)
    public static int StoreWater(ArrayList<Integer> height) {
        int maxWater = 0;
        for(int i=0; i<height.size(); i++) {
            for(int j=i+1; j<height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int wd = j-i;
                int currentWater = ht * wd;
                maxWater = Math.max(maxWater, currentWater);
            }
        }
        return maxWater;
    }

        //2 Pointer Approach - O(n)
    public static int StoredWater(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.size() - 1;
        while(lp < rp) {
            //calculate water area
            int ht = Math.min(height.get(lp), height.get(rp));
            int wd = rp-lp;
            int currentWater = ht * wd;
            maxWater = Math.max(maxWater, currentWater);
            //update area
            if(height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }
    public static void main(String args[]) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(StoredWater(height));
    }
}
