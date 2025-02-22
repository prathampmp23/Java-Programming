package BinaryTrees;

import java.util.*;

public class TopViewOfTree {
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

    static class Info {
        Node node;
        int hd;

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        // Level order
        Queue<Info> q = new LinkedList<>();

        HashMap<Integer, Node> map = new HashMap<>();

        int max = 0, min = 0;
        q.add(new Info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info curr = q.remove();

            // If level is over or loop ends
            if (curr == null) {
                if (q.isEmpty()) { // break from loop
                    break;
                } else { // insert null for next level
                    q.add(null);
                }
            } else {
                // process for horizontal distance

                // check is hd is exist in map
                if (!map.containsKey(curr.hd)) { // first time my hd is occuring
                    map.put(curr.hd, curr.node);
                }

                // check for left child
                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                // check for right child
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        // Print the top view
       for (int i = min; i <= max; i++) {
           System.out.print(map.get(i).data + " ");
       }
       System.out.println();

    }

    public static void main(String[] args) {
        // Tree
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

        topView(root);
    }
}