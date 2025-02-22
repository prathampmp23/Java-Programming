package BinaryTrees;

import java.util.*;

public class LowestCommonAncestor {

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

    // Approach 1
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        // add path
        path.add(root);

        // if data found
        if (root.data == n) {
            return true;
        }

        // else find data in
        boolean foundLeft = getPath(root.left, n, path); // left subtree
        boolean foundRight = getPath(root.right, n, path); // right subtree

        // if exist in any one of subtrees
        if (foundLeft || foundRight) {
            return true;
        }

        // current node is not a part of path
        path.remove(path.size() - 1);
        return false;
    }

    // T.c = O(n)
    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        // get path from root to n1
        getPath(root, n1, path1);
        // get path from root to n2
        getPath(root, n2, path2);

        // Last common Ancestor
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            // when they are unequal in terms of values
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // last equal node value -> i - 1th
        Node lca = path1.get(i - 1);
        return lca;
    }

    // Approach 2
    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        // leftLca -> value & rightLca -> null
        if (rightLca == null) {
            return leftLca;
        }
        // leftLca -> null & rightLca -> value
        if (leftLca == null) {
            return rightLca;
        }

        return root;
    }

    public static void main(String[] args) {
        /*
                 1
               /  \
              2    3
             / \  / \
            4  5 6   7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 5;
        System.out.println("Lowest common Ancestor = " + lca(root, n1, n2).data);
        System.out.println("Lowest common Ancestor = " + lca2(root, n1, n2).data);
    }
}
