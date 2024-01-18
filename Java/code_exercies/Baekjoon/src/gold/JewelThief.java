package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Baekjoon 1202
 * @link https://www.acmicpc.net/problem/1202
 */
public class JewelThief {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        Jewel[] jewels = new Jewel[N];
        int[] bags = new int[K];
        long answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(m, v);
        }
        List<Jewel> sortedJewel = Arrays.stream(jewels).sorted((o1, o2) -> Integer.compare(o1.weight, o2.weight)).collect(Collectors.toList());
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        bags = Arrays.stream(bags).sorted().toArray();

        PriorityQueue<Jewel> pq = new PriorityQueue<>();
        int jewelIdx = 0;
        for (int i = 0; i < K; i++) {
            int limit = bags[i];
            while(jewelIdx < N && sortedJewel.get(jewelIdx).weight <= limit) {
                pq.offer(sortedJewel.get(jewelIdx));
                ++jewelIdx;
            }
            if(!pq.isEmpty()) {
                answer += pq.poll().price;
            }
        }

        System.out.println(answer);
        br.close();
    }


    static class Jewel implements Comparable<Jewel> {
        int weight;
        int price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        //Higher Price, then lighter
        @Override
        public int compareTo(Jewel o) {
            if(this.price == o.price) {
                return Integer.compare(this.weight, o.weight);
            }
            return Integer.compare(o.price, this.price);
        }
    }

}
