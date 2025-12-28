package BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecoverBST {

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

    // Brute
    int idx = 0;
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        Collections.sort(list);
        inorderChange(root, list);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public void inorderChange(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderChange(root.left, list);
        if (root.val != list.get(idx)) {
            root.val = list.get(idx);
        }
        idx++;
        inorderChange(root.right, list);
    }

    // Optimal
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree2(TreeNode root) {
        inorder2(root);
        // swap two nodes value
        int curr = first.val;
        first.val = second.val;
        second.val = curr;
    }

    private void inorder2(TreeNode root) {
        if (root == null) return;
        inorder2(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        inorder2(root.right);
    }
}