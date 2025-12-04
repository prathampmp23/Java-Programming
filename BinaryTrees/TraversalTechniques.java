package BinaryTrees;

import java.util.*;

public class TraversalTechniques {
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

    static class BinaryTree {
        static int idx = -1;

        // Time complexity = O(n)
        public static Node buildTree(int nodes[]) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // **** Depth-First Search (DFS) ****
        // Explores a binary tree by going as deeply as possible along each branch
        // before backtracking.

        // 1. Preorder
        // 2. Inorder
        // 3. Post order

        // Preorder
        public static void preorder(Node root) { // O(n)
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // Inorder
        public static void inorder(Node root) { // O(n)
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // Post order
        public static void postorder(Node root) { // O(n)
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        // **** Breadth-First Search (BFS) ****
        // Explores a binary tree level by level, visiting all nodes at a given level
        // before processing to the next level

        // Level order
        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }

        }
    }

    // Another method
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                level.add(node.data);

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // BinaryTree tree = new BinaryTree();
        Node root = BinaryTree.buildTree(nodes);
        // System.out.println(root.data);

        System.out.print("Preorder = ");
        BinaryTree.preorder(root);
        System.out.println();

        System.out.print("Inorder = ");
        BinaryTree.inorder(root);
        System.out.println();

        System.out.print("Postorder = ");
        BinaryTree.postorder(root);
        System.out.println();

        System.out.println("Levelorder = ");
        BinaryTree.levelOrder(root);
        System.out.println();
    }
}
