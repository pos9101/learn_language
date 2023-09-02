package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 2920
 * @link https://www.acmicpc.net/problem/2920
 */
public class QuestScale {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] scale = new int[8];
        for (int i = 0; i < 8; i++) {
            scale[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(verifyScale(scale));

        br.close();
        
    }

    public static String verifyScale(int[] scale){
        String mixed = "mixed";
        String result = null;
        result = verifyAscending(scale);
        if(result != null) {
            return result;
        }
        result = verifyDescending(scale);

        return (result != null) ? result : mixed;
    }

    private static String verifyAscending(int[] scale) {
        String ascending = "ascending";
        for (int i = 0; i < 8; i++) {
            if(scale[i] != i + 1) {
                return null;
            }
        }
        return ascending;
    }

    private static String verifyDescending(int[] scale) {
        String descending = "descending";
        for (int i = 0; i < 8; i++) {
            if(scale[i] != 8 - i) {
                return null;
            }
        }
        return descending;
    }
}
