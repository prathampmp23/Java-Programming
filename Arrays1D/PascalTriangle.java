package Arrays1D;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            ans.add(grnerateRow(i));
        }
        return ans;
    }

    public static List<Integer> grnerateRow(int row) {
        int ans = 1;
        List<Integer> list = new ArrayList<>();
        list.add(ans);
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / (col);
            list.add(ans);
        }
        return list;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = generate(numRows);

        System.out.println("Pascal's Triangle with " + numRows + " rows:");
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
