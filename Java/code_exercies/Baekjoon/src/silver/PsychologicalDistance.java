package silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 20529
 * @link https://www.acmicpc.net/problem/20529
 */
public class PsychologicalDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            final int N = Integer.parseInt(br.readLine());
            if(N > 32) {
                br.readLine();
                bw.write("0\n");
            } else {
                bw.write(takeMinDistance(br, N) + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int takeMinDistance(BufferedReader br, final int N) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int minDistance = Integer.MAX_VALUE;
        String[] people = new String[N];
        for (int i = 0; i < N; i++) {
            people[i] = st.nextToken();
        }
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int val = calDistance(people[i], people[j]) + calDistance(people[j], people[k])
                            + calDistance(people[i], people[k]);
                    if (val < minDistance) {
                        minDistance = val;
                    }
                }
            }
        }
        return minDistance;
    }

    private static int calDistance(String person1, String person2) {
        int distance = 0;
        for (int i = 0; i < person1.length(); i++) {
            if (person1.charAt(i) != person2.charAt(i)) {
                ++distance;
            }
        }
        return distance;
    }
}
