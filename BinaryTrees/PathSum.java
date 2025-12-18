package BinaryTrees;

import java.util.ArrayList;

public class PathSum {
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

    // 
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        return getPath(root, new ArrayList<>(),0, targetSum);
    }

    public static boolean getPath(TreeNode node, ArrayList<Integer> path, int currSum, int targetSum) { 
        if (node == null) return false;

        path.add(node.val);
        currSum += node.val;

        // Leaf node
        if (node.left == null && node.right == null) {
            if(currSum == targetSum) return true;
        } else {
            if (getPath(node.left, path, currSum, targetSum)) return true;
            if (getPath(node.right, path, currSum, targetSum)) return true;

        }
        currSum -= path.get(path.size() - 1);
        path.remove(path.size() - 1); // backtrack
        return false;
    }


    public boolean hasPathSum2(TreeNode root, int targetSum) {
        return getPath(root, 0, targetSum);
    }

    public boolean getPath(TreeNode node, int currSum, int targetSum) {
        if (node == null) return false;
        currSum += node.val;
        // Leaf node
        if (node.left == null && node.right == null) {
            return currSum == targetSum;
        }
        return getPath(node.left, currSum, targetSum) || getPath(node.right, currSum, targetSum);
    }

    // Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
    // Output: true
    // Explanation: The root-to-leaf path with the target sum is shown.
}

