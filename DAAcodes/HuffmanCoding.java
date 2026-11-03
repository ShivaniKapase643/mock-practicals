
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanCoding {

    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        Node(int freq, Node left, Node right) {
            this.ch = '-';
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    // Generate Huffman Codes
    static void printCodes(Node root, String code) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    // Build Huffman Tree using Greedy Strategy
    static void huffman(char[] chars, int[] freq, int n) {
        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a.freq, b.freq));

        for (int i = 0; i < n; i++) {
            pq.add(new Node(chars[i], freq[i]));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(
                    left.freq + right.freq, left, right);

            pq.add(parent);
        }

        Node root = pq.poll();

        System.out.println("\nHuffman Codes:");
        printCodes(root, "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Number of characters must be positive.");
            sc.close();
            return;
        }

        char[] chars = new char[n];
        int[] freq = new int[n];

        System.out.println("Enter characters and their frequencies:");

        for (int i = 0; i < n; i++) {
            chars[i] = sc.next().charAt(0);
            freq[i] = sc.nextInt();

            if (freq[i] <= 0) {
                System.out.println("Frequency must be positive.");
                sc.close();
                return;
            }
        }

        huffman(chars, freq, n);

        sc.close();
    }
}
