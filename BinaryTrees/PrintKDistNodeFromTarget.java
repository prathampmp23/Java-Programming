package BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PrintKDistNodeFromTarget {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parent_track) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                parent_track.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                parent_track.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
    }

    public ArrayList<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParent(root, parent_track); // marks parents of each leaf nodes
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (curr_level == k) {
                break;
            }
            curr_level++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null && visited.get(curr.left) == null) {
                    queue.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if (curr.right != null && visited.get(curr.right) == null) {
                    queue.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if (parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null) {
                    queue.offer(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            ans.add(curr.val);
        }
        return ans;
    }

    public static void main(String[] args) {
        // root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
        // Output: [7,4,1]
        // Explanation: The nodes that are a distance 2 from the target node (with value
        // 5) have values 7, 4, and 1.
    }
}
