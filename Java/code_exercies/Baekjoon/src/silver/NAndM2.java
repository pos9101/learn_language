package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 15650
 * @link https://www.acmicpc.net/problem/15650
 */
public class NAndM2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N ; i++) {
            visited[i] = true;
            printCollections(visited, M, i, 1);
            visited[i] = false;
        }
        br.close();
    }

    private static void printCollections(boolean[] visited, int exitNum, int searchedIndex, int presentNum) {
        if(presentNum == exitNum) {
            for (int i = 1; i < visited.length; i++) {
                if(visited[i] == true) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }
        for (int i = searchedIndex + 1; i < visited.length; i++) {
            visited[i] = true;
            printCollections(visited, exitNum, i, presentNum + 1);
            visited[i] = false;
        }
    }
}
