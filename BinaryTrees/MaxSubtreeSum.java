package BinaryTrees;

public class MaxSubtreeSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    long totalSum = 0;
    long maxProduct = 0;
    static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        totalSum = dfs(root);
        subtreeSum(root);
        return (int) (maxProduct % MOD);
    }

    private long dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + dfs(node.left) + dfs(node.right);
    }

    private long subtreeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        long leftSum = subtreeSum(node.left);
        long rightSum = subtreeSum(node.right);

        long subtreeSum = leftSum + rightSum + node.val;

        long product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subtreeSum;
    }
}
