import java.util.PriorityQueue;
import java.util.Scanner;

// Node class to store each character and its frequency
class Node {
    char ch;
    int freq;
    Node left = null, right = null;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    Node(char ch, int freq, Node left, Node right) {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

// Huffman Coding class
public class HuffmanCoding {

    // Recursive function to print the Huffman codes
    public static void printCodes(Node root, String str) {
        if (root == null)
            return;

        // Leaf node
        if (root.left == null && root.right == null)
            System.out.println(root.ch + ": " + str);

        printCodes(root.left, str + "0");
        printCodes(root.right, str + "1");
    }

    public static void buildHuffmanTree(String text) {
        // Count frequency of each character
        int[] freq = new int[256];
        for (char c : text.toCharArray()) {
            freq[c]++;
        }

        // Create a priority queue to store nodes of the Huffman tree
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);

        // Add each character to the priority queue
        for (char i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                pq.add(new Node(i, freq[i]));
            }
        }

        // Loop until there is more than one node in the queue
        while (pq.size() > 1) {
            // Remove the two nodes of highest priority (lowest frequency)
            Node left = pq.poll();
            Node right = pq.poll();

            // Create a new internal node with these two nodes as children
            // and with frequency equal to the sum of the two nodes' frequencies
            int sum = left.freq + right.freq;
            pq.add(new Node('\0', sum, left, right));
        }

        // Root node
        Node root = pq.peek();

        // Print the Huffman codes
        System.out.println("Huffman Codes are:");
        printCodes(root, "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text to be encoded: ");
        String text = sc.nextLine();

        buildHuffmanTree(text);
        sc.close();
    }
}
