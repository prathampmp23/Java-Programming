package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class ParhSum2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        getPath(root, new ArrayList<>(), 0, targetSum, ans);
        return ans;
    }

    public static void getPath(TreeNode node, ArrayList<Integer> path, int currSum, int targetSum, List<List<Integer>> ans) {
        if (node == null)
            return;

        path.add(node.val);
        currSum += node.val;

        // Leaf node
        if (node.left == null && node.right == null) {
            if (currSum == targetSum) {
                ans.add(new ArrayList<>(path)); 
            }
        } else {
            getPath(node.left, path, currSum, targetSum, ans);
            getPath(node.right, path, currSum, targetSum, ans);
        }
        currSum -= path.get(path.size() - 1);
        path.remove(path.size() - 1); // backtrack
    }

    // Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
    // Output: [[5,4,11,2],[5,8,4,5]]
    // Explanation: There are two paths whose sum equals targetSum:
    // 5 + 4 + 11 + 2 = 22
    // 5 + 8 + 4 + 5 = 22
}
