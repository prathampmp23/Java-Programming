package BinaryTrees;

public class HeightOfTree {
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

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        int Lh = height(root.left);
        int Rh = height(root.right);
        return Math.max(Lh, Rh) + 1;
    }

    public static void main(String[] args) {
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

        System.out.println("Height of tree = "+height(root));
    }
}
