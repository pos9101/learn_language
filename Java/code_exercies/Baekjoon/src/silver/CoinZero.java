package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 11047
 * @link https://www.acmicpc.net/problem/11047
 */
public class CoinZero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        int[] array = br.lines().limit(N).mapToInt(Integer::parseInt).toArray();

        int ret = 0;
        int remainer = K;
        for (int i = array.length -1; i >= 0; i--) {
            ret += remainer / array[i];
            remainer =  remainer % array[i];
        }

        System.out.println(ret);
        br.close();
    }
}
