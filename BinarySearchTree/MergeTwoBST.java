package BinarySearchTree;

import java.util.*;

public class MergeTwoBST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Preorder to print Nodes
    public static void preorder(Node root) { // O(n)
        if (root == null) {
            return; // return control
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // InOrder to get sorted sequence
    public static void getInOrder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        getInOrder(root.left, list);
        list.add(root.data);
        getInOrder(root.right, list);
    }

    public static Node createBalancedBST(ArrayList<Integer> arr, int st, int ed) {
        if (st > ed) {
            return null;
        }
        int mid = (st + ed) / 2;
        Node root = new Node(arr.get(mid));
        root.left = createBalancedBST(arr, st, mid - 1);
        root.right = createBalancedBST(arr, mid + 1, ed);
        return root;
    }

    public static Node merge2BST(Node root1, Node root2) {

        // Get Inorder sequence
        // BST1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInOrder(root1, arr1);

        // BST2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInOrder(root2, arr2);

        // Merge BST1 and BST2
        int i = 0, j = 0;
        ArrayList<Integer> finalList = new ArrayList<>();

        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalList.add(arr1.get(i));
                i++;
            } else {
                finalList.add(arr2.get(j));
                j++;
            }
        }

        while (i < arr1.size()) {
            finalList.add(arr1.get(i));
            i++;
        }

        while (j < arr1.size()) {
            finalList.add(arr2.get(j));
            j++;
        }

        // Sorted arrayList -> Balanced BST
        return createBalancedBST(finalList, 0, finalList.size() - 1);
    }

    public static void main(String args[]) {
        // BST 1
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        // BST 2
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        // T.c = O(n+m)
        Node root = merge2BST(root1, root2);
        preorder(root);
    }
}
