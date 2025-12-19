package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                str.append("n ");
                continue;
            }
            str.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "")
            return null;
        Queue<TreeNode> q = new LinkedList<>();

        String values[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
                  / \
                 4   5
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        SerializeAndDeserialize ser = new SerializeAndDeserialize();
        SerializeAndDeserialize deser = new SerializeAndDeserialize();

        // Serialize
        String serialized = ser.serialize(root);
        System.out.println("Serialized Tree:");
        System.out.println(serialized);

        // Deserialize
        TreeNode deserializedRoot = deser.deserialize(serialized);

        // Serialize again to verify correctness
        String verify = ser.serialize(deserializedRoot);
        System.out.println("After Deserialization & Re-serialization:");
        System.out.println(verify);
    }
}
