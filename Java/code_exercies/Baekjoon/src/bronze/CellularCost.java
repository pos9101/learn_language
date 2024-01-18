package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 1267
 * @link https://www.acmicpc.net/problem/1267
 */
public class CellularCost {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int yCost = 0;
        int mCost = 0;
        for (int i = 0; i < N; i++) {
            int time = Integer.parseInt(st.nextToken());
            yCost += 10 * (time / 30 + 1);
            mCost += 15 * (time / 60 + 1);
        }
        System.out.println(calCost(yCost, mCost));
        br.close();
    }

    private static String calCost(int yCost, int mCost) {
        if (yCost > mCost) return "M " + mCost;
        if (yCost < mCost) return "Y " + yCost;
        return "Y M " + yCost;
    }
}
