package BinarySearchTree;

public class KthMinNode {
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
    int cnt = 0;
    int ans = 0;
    boolean found = false;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }

    public void inOrder(TreeNode root, int k) {
        if (root == null || found) return;
        inOrder(root.left, k);
        if (found) return;
        cnt++;
        if (cnt == k) {
            ans = root.val;
            found = true;
            return;
        }
        inOrder(root.right, k);
    }
}
