package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Baekjoon 1043
 * @link https://www.acmicpc.net/problem/1043
 */
public class Lie {
    static BufferedReader br;
    static int[] array;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        array = new int[N + 1];
        for (int i = 0; i <= N; i++) array[i] = i;
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> knowing = new ArrayList<>();
        List<Integer>[] parties = new ArrayList[M];
        int truthNum = Integer.parseInt(st.nextToken());
        for (int i = 0; i < truthNum; i++) knowing.add(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < M; i++) {
            parties[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            int candidates = Integer.parseInt(st.nextToken());
            for (int j = 0; j < candidates; j++) {
                parties[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        if (knowing.isEmpty()) {
            System.out.println(parties.length);
        } else {
            union(knowing);
            for (int i = 0; i < parties.length; i++) {
                union(parties[i]);
            }
            int answer = 0;
            for (int i = 0; i < parties.length; i++) {
                if(root(knowing.get(0)) != root(parties[i].get(0))) ++answer;
            }
            System.out.println(answer);
        }
        br.close();
    }

    static int root(int v) {
        while (v != array[v]) {
            array[v] = array[array[v]];
            v = array[v];
        }
        return v;
    }

    static void union(List<Integer> party) {
        int first = -1;
        for (Integer people : party) {
            if(first == -1) {
                first = people;
                continue;
            }
            union(first, people);
        }
    }

    //from b to a union
    static void union(int a, int b) {
        int rootA = root(a);
        int rootB = root(b);
        if (rootA == rootB) return;
        array[rootB] = rootA;
    }


}
