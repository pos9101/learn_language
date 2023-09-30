package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * Baekjoon 17499
 * @link https://www.acmicpc.net/problem/17499
 */
public class SequenceAndShiftQuery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int Q = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        //[0] ~ [N-1]
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int shiftVar = 0;
        //cal shiftNum and calculate 1
        for (int i = 0; i < Q; i++) {
            String command = br.readLine();
            shiftVar = (shiftVar + calculateQuery(array, command, shiftVar)) % N;
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < N; i++) {
            sj.add(String.valueOf(array[(shiftVar + i) % N]));
        }
        System.out.println(sj.toString());
        br.close();
    }

    private static int calculateQuery(int[] array, String command, int shiftVar) {
        final int N = array.length;
        StringTokenizer st = new StringTokenizer(command, " ");
        switch(st.nextToken()) {
            case "1":
                final int i = (Integer.parseInt(st.nextToken()) - 1);
                final int x = Integer.parseInt(st.nextToken());
                int index = (i + shiftVar) % N;
                array[index] += x;
                return 0;
            case "2":
                return N -Integer.parseInt(st.nextToken());
            case "3":
            default:
                return Integer.parseInt(st.nextToken());

        }
    }
}
