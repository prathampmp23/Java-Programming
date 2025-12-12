package BinaryTrees;

import java.util.ArrayList;

public class RootToLeafPath {
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
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        getPath(root, new ArrayList<>(), ans);
        return ans;
    }
    
    public static void getPath(Node node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans) { 
        if (node == null) return;

        path.add(node.data);

        // Leaf node
        if (node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path)); 
        } else {
            getPath(node.left, path, ans);
            getPath(node.right, path, ans);
        }

        path.remove(path.size() - 1); // backtrack
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

        ArrayList<ArrayList<Integer>> ans = Paths(root);
        for(ArrayList<Integer> n : ans) {
            System.out.println(n);
        }
    }
}
