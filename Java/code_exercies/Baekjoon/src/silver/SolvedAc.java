package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 18110
 * @link https://www.acmicpc.net/problem/18110
 */
public class SolvedAc {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int exceptNum = takeExceptNum(n, 0.15f);
        int sum = 0;

        int[] levelArray = new int[31];

        for (int i = 0; i < n; i++) {
            byte level = Byte.parseByte(br.readLine());
            levelArray[level]++;
            sum += level;
        }

        sum -= takeExceptLowerValue(levelArray, n, exceptNum);
        sum -= takeExceptUpperValue(levelArray, n, exceptNum);

        System.out.println(Math.round((sum / (float)(n - exceptNum - exceptNum))));

        br.close();
    }

    public static int takeExceptNum(int total, float rate) {
        return Math.round(total * rate);
    }

    public static int takeExceptLowerValue(int[] levelArray, int totalNum, int exceptNum) {
        int exceptValue = 0;
        for (int level = 1; level <= 30; level++) {
            if(exceptNum <= levelArray[level]) {
                return exceptValue + (exceptNum * level);
            }
            exceptValue += levelArray[level] * level;
            exceptNum -= levelArray[level];
        }
        return exceptValue;
    }

    public static int takeExceptUpperValue(int[] levelArray, int totalNum, int exceptNum) {
        int exceptValue = 0;
        for (int level = 30; level >= 1; level--) {
            if(exceptNum <= levelArray[level]) {
                return exceptValue + (exceptNum * level);
            }
            exceptValue += levelArray[level] * level;
            exceptNum -= levelArray[level];
        }
        return exceptValue;
    }
}
