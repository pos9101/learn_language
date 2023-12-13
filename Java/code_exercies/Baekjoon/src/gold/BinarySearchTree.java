package gold;

import java.io.*;

/**
 * Baekjoon 5639
 * @link https://www.acmicpc.net/problem/5639
 */
public class BinarySearchTree {
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        Node root = new Node(Integer.parseInt(line));
        while ((line = br.readLine()) != null) {
            if(line.equals("")) break; //for IDE Debugging
            int value = Integer.parseInt(line);
            root.addChild(value);
        }
        postOrder(root);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void postOrder(Node root) throws IOException {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        bw.write(root.v + "\n");
    }

    private static class Node {
        int v;
        Node left;
        Node right;

        public Node(int v) {
            this.v = v;
        }

        public void addChild(int child) {
            if(child < v) {
                if (left != null) {
                    left.addChild(child);
                    return;
                }
                left = new Node(child);
            } else {
                if (right != null) {
                    right.addChild(child);
                    return;
                }
                right = new Node(child);
            }
        }
    }
}
