package BinaryTrees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinTimeToBurnBT {
    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    private TreeNode mapParents(TreeNode root, Map<TreeNode, TreeNode> parentMap, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode target = null;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.data == start) target = node;

            if (node.left != null) {
                parentMap.put(node.left, node);
                q.offer(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                q.offer(node.right);
            }
        }
        return target;
    }

    // BFS to calculate time to burn tree
    private int burnTime(TreeNode target, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                // Left
                if (node.left != null && !visited.contains(node.left)) {
                    burned = true;
                    visited.add(node.left);
                    q.offer(node.left);
                }
                // Right
                if (node.right != null && !visited.contains(node.right)) {
                    burned = true;
                    visited.add(node.right);
                    q.offer(node.right);
                }
                // Parent
                TreeNode parent = parentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    burned = true;
                    visited.add(parent);
                    q.offer(parent);
                }
            }
            if (burned) time++;
        }
        return time;
    }

    // REQUIRED METHOD
    public int timeToBurnTree(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode target = mapParents(root, parentMap, start);
        return burnTime(target, parentMap);
    }

    public static void main(String[] args) {
        // Input : root = [1, 2, 3, 4, null, 5, 6, null, 7]. target = 1

        // Output : 3
        // Explanation : The node with value 1 is set on fire.
        // In 1st second it burns node 2 and node 3.
        // In 2nd second it burns nodes 4, 5, 6.
        // In 3rd second it burns node 7.
    }
}
