package BinarySearchTree;

import java.util.Arrays;
import java.util.HashMap;

public class ConstructBstFromPreorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode bstFromPreorder(int[] preOrder) {
        int inOrder[] = new int[preOrder.length];
        int idx = 0;
        for (int n : preOrder) {
            inOrder[idx++] = n;
        }
        Arrays.sort(inOrder);
        HashMap<Integer, Integer> inMap = new HashMap<>();
        // store inOrder values map with index
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }

        // recursion
        TreeNode root = buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, inMap);
        return root;
    }

    public TreeNode buildTree(int preOrder[], int preStart, int preEnd, int inOrder[], int inStart, int inEnd,
            HashMap<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preOrder[preStart]);
        int inRoot = inMap.get(root.val); // get root index
        int numsLeft = inRoot - inStart; // to get no of left elements

        root.left = buildTree(preOrder, preStart + 1, preStart + numsLeft, inOrder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preOrder, preStart + numsLeft + 1, preEnd, inOrder, inRoot + 1, inEnd, inMap);
        return root;
    }

    // Input: preorder = [8,5,1,7,10,12]
    // Output: [8,5,10,1,7,null,12]
}
