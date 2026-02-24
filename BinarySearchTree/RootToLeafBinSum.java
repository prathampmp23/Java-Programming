public class RootToLeafBinSum {

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

    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        rec(root, new StringBuilder());
        return sum;
    }

    public void rec(TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            sum += Integer.parseInt(sb.toString(), 2); // bin to decimal conversion
            return;
        }
        sb.append(root.val);
        if (root.left != null) {
            rec(root.left, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (root.right != null) {
            rec(root.right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /*
     * Input: root = [1,0,1,0,1,0,1]

                         1
                      /    \
                    0       1
                  /   \   /   \
                 0     1 0     1
                 
     * Output: 22
     * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
     */

}