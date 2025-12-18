package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
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

    public int minDepth(TreeNode root) {
        // *** Using recursion ***
        // return height(root);

        // *** Using BFS (level Order) ***
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                // if leafNode return depth
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

    public int height(TreeNode node) {
        if (node == null) return 0;

        int leftH = height(node.left);
        int rightH = height(node.right);

        if (node.left == null) return rightH + 1;
        if (node.right == null) return leftH + 1;
        return Math.min(leftH, rightH) + 1;
    }

    // Input: root = [3,9,20,null,null,15,7]
    // Output: 2

    // Input: root = [2,null,3,null,4,null,5,null,6]
    // Output: 5
}
