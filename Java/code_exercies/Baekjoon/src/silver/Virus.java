package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 2606
 * @link https://www.acmicpc.net/problem/2606
 */
public class Virus {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int numOfComputer = Integer.parseInt(br.readLine());
        final int numOfEdge = Integer.parseInt(br.readLine());
        int[] array = new int[numOfComputer + 1];
        int[] sizeOfUnion = new int[numOfComputer + 1];
        Arrays.fill(sizeOfUnion, 1);
        for (int i = 1; i < array.length; i++) {
            array[i] = i;
        }
        for (int i = 0; i < numOfEdge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(array, sizeOfUnion, a, b);
        }
        System.out.println(sizeOfUnion[root(array, 1)] - 1); //except 1
        br.close();
    }

    private static void union(int[] array, int[] sizeOfUnion, int a, int b) {
        int rootA = root(array, a);
        int rootB = root(array, b);
        if(rootA == rootB) return;
        if(sizeOfUnion[a] < sizeOfUnion[b]) {
            array[rootA] = rootB;
            sizeOfUnion[rootB] += sizeOfUnion[rootA];
        } else {
            array[rootB] = rootA;
            sizeOfUnion[rootA] += sizeOfUnion[rootB];
        }
    }

    private static int root(int[] array, int node) {
        while (node != array[node]) {
            array[node] = array[array[node]];
            node = array[node];
        }
        return node;
    }

    private static boolean isConnected(int[] array, int a, int b) {
        return root(array, a) == root(array, b);
    }
}
