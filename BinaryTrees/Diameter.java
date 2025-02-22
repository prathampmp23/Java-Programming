package BinaryTrees;

public class Diameter {
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
        if (root == null) {
            return 0;
        }
        int Lh = height(root.left);
        int Rh = height(root.right);
        return Math.max(Lh, Rh) + 1;
    }

    //  ** Approach I
    // T.C = O(n^2)
    public static int diameter1(Node root) {
        if (root == null) {
            return 0;
        }
        int Lh = height(root.left);
        int LDiameter = diameter1(root.left);
        int Rh = height(root.right);
        int RDiameter = diameter1(root.right);

        int selfDiameter = Lh + Rh + 1;
        return Math.max(selfDiameter, Math.max(LDiameter, RDiameter));
    }


    //  ** Approach II
    // T.C = O(n)
    static class Info {
        int dia;
        int ht;

        Info(int dia, int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }

    public static Info diameter2(Node root) {
        if (root == null) {
            return new Info(0,0);
        }
        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int dia = Math.max(Math.max(leftInfo.dia, rightInfo.dia), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(dia, ht);
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

        System.out.println("Diameter of tree = " + diameter1(root));
        System.out.println("Diameter of tree = " + diameter2(root).dia);
        System.out.println("Height of tree = " + diameter2(root).ht);
    }
}
