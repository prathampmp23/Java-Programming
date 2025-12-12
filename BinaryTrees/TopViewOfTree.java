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
        int horiDict;

        public Info(Node node, int horiDict) {
            this.node = node;
            this.horiDict = horiDict;
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

                // check is horiDict is exist in map
                if (!map.containsKey(curr.horiDict)) { // first time my horiDict is occuring
                    map.put(curr.horiDict, curr.node);
                }

                // check for left child
                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.horiDict - 1));
                    min = Math.min(min, curr.horiDict - 1);
                }

                // check for right child
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.horiDict + 1));
                    max = Math.max(max, curr.horiDict + 1);
                }
            }
        }

        // Print the top view
       for (int i = min; i <= max; i++) {
           System.out.print(map.get(i).data + " ");
       }
       System.out.println();

    }

    public static ArrayList<Integer> topView2(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<Info> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.add(new Info(root, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            int horiDict = curr.horiDict;
            Node temp = curr.node;
            if (!map.containsKey(horiDict))
                map.put(horiDict, temp.data);
            if (temp.left != null)
                q.add(new Info(temp.left, horiDict - 1));
            if (temp.right != null)
                q.add(new Info(temp.right, horiDict + 1));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
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
        ArrayList<Integer> ans = topView2(root);
        System.out.println(ans);
    }
}