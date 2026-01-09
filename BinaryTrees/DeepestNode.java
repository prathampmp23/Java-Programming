package BinaryTrees;

public class DeepestNode {
    // 865. Smallest Subtree with all the Deepest Nodes
    // 1123. Lowest Common Ancestor of Deepest Leaves
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Result {
        TreeNode node;
        int depth;

        Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Result ans = dfs(root);
        return ans.node;
    }

    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(null, 0);
        }

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        // left.depth > right.depth return left node
        if (left.depth > right.depth) {
            return new Result(left.node, left.depth + 1);
        }

        // left.depth < right.depth return right node
        if (right.depth > left.depth) {
            return new Result(right.node, right.depth + 1);
        }

        // left.depth == right.depth
        return new Result(root, left.depth + 1);
    }

    /*
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4]
     * Output: [2,7,4]
     */
}
