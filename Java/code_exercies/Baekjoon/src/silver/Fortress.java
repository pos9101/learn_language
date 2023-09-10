package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * Baekjoon 11866
 * @link https://www.acmicpc.net/problem/11866
 */
public class Fortress {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner(", ", "<", ">");
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        LinkedList<Short> word = new LinkedList<>();
        for (short i = 1; i <= N; i++) {
            word.add(i);
        }

        for (short i = 0; i < N; i++) {
            sj.add(String.valueOf(popInList(word, K)));
        }


        System.out.println(sj.toString());

        br.close();
    }

    private static short popInList(LinkedList<Short> word, final int ORDER) {
        for(int i = 0; i < ORDER - 1; i++) {
            short first = word.removeFirst();
            word.addLast(first);
        }
        return word.removeFirst();
    }
}
