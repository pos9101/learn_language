package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 2805
 * @link https://www.acmicpc.net/problem/2805
 */
public class CutTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final long M = Integer.parseInt(st.nextToken());
        long[] trees = new long[N];
        st = new StringTokenizer(br.readLine(), " ");
        long max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            if(trees[i] > max) {
                max = trees[i];
            }
        }
        System.out.println(solveHeight(trees, M, 1L, max));
        br.close();
    }

    private static long solveHeight(long[] trees, final long M, long min, long max) {
        if(min > max) {
            return max;
        }
        long mid = (min + max) / 2;
        long cuttingValue = 0;
        for (long tree : trees) {
            cuttingValue += lengthOfCuttingTree(mid, tree);
        }
        if(cuttingValue >= M) {
            return solveHeight(trees, M, mid + 1, max);
        } else {
            return solveHeight(trees, M, min, mid - 1);
        }
    }

    private static long lengthOfCuttingTree(long height, long treeHeight) {
        if(treeHeight <= height) {
            return 0;
        }
        return treeHeight - height;
    }
}
