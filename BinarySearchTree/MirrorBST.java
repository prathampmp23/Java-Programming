package BinarySearchTree;

public class MirrorBST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

     // Preorder
     public static void preorder(Node root) { // O(n)
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node mirrorBst(Node root) { // O(n)
        if (root == null) {
            return null;
        }

        // mirror left and right subtree
        Node leftMirror = mirrorBst(root.left);
        Node rightMirror = mirrorBst(root.right);

        // pointing mirror subtrees
        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    public static void main(String[] args) {
        /*
         *       8
         *      / \
         *     5  10
         *    / \  \
         *   3  6   11
         */

         Node root = new Node(8);
         root.left = new Node(5);
         root.right = new Node(10);
         root.left.left = new Node(3);
         root.left.right = new Node(6);
         root.right.right = new Node(11);

         mirrorBst(root);

         preorder(root);
    }
}