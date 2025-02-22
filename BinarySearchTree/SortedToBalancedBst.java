package BinarySearchTree;

public class SortedToBalancedBst {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

     // Preorder 
     public static void preorder(Node root) { // O(n)
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

      public static Node createBalancedBST(int arr[], int st, int ed) {
        if (st > ed) {
            return null;
        }
        int mid = (st+ed) / 2;
        Node root = new Node(arr[mid]);

        root.left = createBalancedBST(arr, st, mid-1);
        root.right = createBalancedBST(arr, mid+1, ed);

        return root;
      } 
    

    public static void main(String[] args) {
        int arr[] = { 3, 5, 6, 8, 10, 11, 12};
        
        /*
                   8
                  / \
                 5  10
                / \  \
               3  6   11
         */

        Node root = createBalancedBST(arr, 0, arr.length-1);
        preorder(root);
    }
}