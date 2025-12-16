package BinaryTrees;

import java.util.HashMap;

public class ConstructBtFromPreAndInOrder {
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

    public TreeNode buildTree(int preOrder[], int inOrder[]) {
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

    public static void main(String[] args) {
        // Input: preorder = [3,9,20,15,7], 
        // inorder = [9,3,15,20,7]

        // Output: [3,9,20,null,null,15,7]
    }
}
