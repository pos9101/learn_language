package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 11054
 * @link https://www.acmicpc.net/problem/11054
 */
public class LongestBitonicSequence {
    private static int N;
    private static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N];
        int[] ascendingMax = new int[N];
        int[] descendingMax = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        fillAscendingMax(ascendingMax);
        fillDescendingMax(descendingMax);
        System.out.println(solveMax(ascendingMax, descendingMax));
        br.close();
    }

    private static void fillAscendingMax(int[] ascendingMax) {
        for (int i = 0; i < N; i++) {
            ascendingMax[i] = takeAscendingValue(ascendingMax, i);
        }
    }

    private static void fillDescendingMax(int[] descendingMax) {
        for (int i = N -1; i >= 0; i--) {
            descendingMax[i] = takeDescendingValue(descendingMax, i);
        }
    }

    private static int takeAscendingValue(int[] ascendingMax, int index) {
        if(ascendingMax[index] != 0) {
            return ascendingMax[index];
        }
        if (index == 0) {
            ascendingMax[index] = 1;
            return ascendingMax[index];
        }
        ascendingMax[index] = 1;
        for (int i = 0; i < index; i++) {
            if(array[index] > array[i] && ascendingMax[i] + 1 > ascendingMax[index]) {
                ascendingMax[index] = ascendingMax[i] + 1;
            }
        }
        return ascendingMax[index];
    }

    private static int takeDescendingValue(int[] descendingMax, int index) {
        if (descendingMax[index] != 0) {
            return descendingMax[index];
        }
        if (index == N - 1) {
            descendingMax[index] = 1;
            return descendingMax[index];
        }
        descendingMax[index] = 1;
        for (int i = N -1; i > index; i--) {
            if (array[index] > array[i] && descendingMax[i] + 1 > descendingMax[index]) {
                descendingMax[index] = descendingMax[i] + 1;
            }
        }
        return descendingMax[index];
    }

    private static int solveMax(int[] ascendingMax, int[] descendingMax) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            int value = ascendingMax[i] + descendingMax[i] - 1;
            if (value > max) max = value;
        }
        return max;
    }
}
