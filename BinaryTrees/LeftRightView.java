package BinaryTrees;

import java.util.ArrayList;

public class LeftRightView {
    static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    // reverse PreOrder travesal to get right view 
    // (Root right left) instead of (Root left right)
    public static void rightView(Node root, int level, ArrayList<Integer> ans) { 
        if (root == null) {
            return;
        }
        if(level == ans.size()) ans.add(root.data);
        rightView(root.right, level + 1, ans);
        rightView(root.left, level + 1, ans);
    }

    public static void leftView(Node root, int level, ArrayList<Integer> ans) { 
        if (root == null) {
            return;
        }
        if(level == ans.size()) ans.add(root.data);
        leftView(root.left, level + 1, ans);
        leftView(root.right, level + 1, ans);
    }

    public static void main(String[] args) {
        // Tree
        /*
                 1
               /  \
              2    3
             / \  / \
            4  5 6   7
              / \
             8   9
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        ArrayList<Integer> ans = new ArrayList<>();
        rightView(root, 0, ans);
        System.out.println("RightView = " + ans);
        ArrayList<Integer> ans2 = new ArrayList<>();
        leftView(root, 0, ans2);
        System.out.println("LeftView = " + ans2);
    }
}
