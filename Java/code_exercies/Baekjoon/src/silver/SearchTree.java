package silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Baekjoon 1991
 * @link https://www.acmicpc.net/problem/1991
 */
public class SearchTree {
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int N = Integer.parseInt(br.readLine());
        Map<Character, Tree> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char node = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);
            if (graph.get(node) == null) {
                graph.put(node, new Tree(node));
            }
            if(leftChild != '.' && graph.get(leftChild) == null) {
                graph.put(leftChild, new Tree(leftChild));
            }
            if(rightChild != '.' && graph.get(rightChild) == null) {
                graph.put(rightChild, new Tree(rightChild));
            }
            graph.get(node).left = graph.get(leftChild);
            graph.get(node).right = graph.get(rightChild);
        }
        preorderTraversal(graph, graph.get('A'));
        bw.write("\n");
        inorderTraversal(graph, graph.get('A'));
        bw.write("\n");
        postorderTraversal(graph, graph.get('A'));
        bw.write("\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void preorderTraversal(Map<Character, Tree> graph, Tree node) throws IOException {
        if(node == null) return;
        bw.write(node.node);
        Tree left = node.left;
        Tree right = node.right;
        preorderTraversal(graph, left);
        preorderTraversal(graph, right);
    }

    private static void inorderTraversal(Map<Character, Tree> graph, Tree node) throws IOException {
        if(node == null) return;
        Tree left = node.left;
        Tree right = node.right;
        inorderTraversal(graph, left);
        bw.write(node.node);
        inorderTraversal(graph, right);
    }

    private static void postorderTraversal(Map<Character, Tree> graph, Tree node) throws IOException {
        if(node == null) return;
        Tree left = node.left;
        Tree right = node.right;
        postorderTraversal(graph, left);
        postorderTraversal(graph, right);
        bw.write(node.node);
    }

    public static class Tree {
        char node;
        Tree left;
        Tree right;

        public Tree(char node) {
            this.node = node;
        }
    }
}
