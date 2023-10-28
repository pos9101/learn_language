package bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 4435
 * @link https://www.acmicpc.net/problem/4435
 */
public class IntermediateWar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int hobbit = Integer.parseInt(st.nextToken());
            long human = Long.parseLong(st.nextToken()) * 2L;
            long elf = Long.parseLong(st.nextToken()) * 3L;
            long dwarf = Long.parseLong(st.nextToken()) * 3L;
            long eagle = Long.parseLong(st.nextToken()) * 4L;
            long wizard = Long.parseLong(st.nextToken()) * 10L;

            st = new StringTokenizer(br.readLine(), " ");
            int oak = Integer.parseInt(st.nextToken());
            long human2 = Long.parseLong(st.nextToken()) * 2L;
            long wolf = Long.parseLong(st.nextToken()) * 2L;
            long goblin = Long.parseLong(st.nextToken()) * 2L;
            long urukhai = Long.parseLong(st.nextToken()) * 3L;
            long troll = Long.parseLong(st.nextToken()) * 5L;
            long wizard2 = Long.parseLong(st.nextToken()) * 10L;

            long gandalfScore = hobbit + human + elf + dwarf + eagle + wizard;
            long sauronScore = oak + human2 + wolf + goblin + urukhai + troll + wizard2;
            if (gandalfScore > sauronScore) {
                bw.write("Battle " + i + ": " + "Good triumphs over Evil\n");
            } else if (gandalfScore < sauronScore) {
                bw.write("Battle " + i + ": " + "Evil eradicates all trace of Good\n");
            } else {
                bw.write("Battle " + i + ": " + "No victor on this battle field\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
