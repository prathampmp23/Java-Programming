package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBT {
    static class TreeNode {
        int data;
        TreeNode right;
        TreeNode left;

        TreeNode(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static class Pair {
        TreeNode node;
        int num;

        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        if (root == null)
            return ans;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int mmin = q.peek().num;
            int first = 0;
            int last = 0;
            for (int i = 0; i < size; i++) {
                int currId = q.peek().num - mmin; // to give id's from 0, 1, 2 ...  
                TreeNode node = q.peek().node;
                q.poll();
                if (i == 0) first = currId;
                if (i == size - 1) last = currId;
                if (node.left != null) q.offer(new Pair(node.left, currId * 2 + 1));
                if (node.right != null) q.offer(new Pair(node.right, currId * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        /*
                 1
               /  \
              2    3
             / \    \
            4  5     7
         */

         TreeNode root = new TreeNode(1);
         root.left = new TreeNode(2);
         root.right = new TreeNode(3);
         root.left.left = new TreeNode(4);
         root.left.right = new TreeNode(5);
         root.right.right = new TreeNode(7);

         System.out.println(widthOfBinaryTree(root));
    }
}
