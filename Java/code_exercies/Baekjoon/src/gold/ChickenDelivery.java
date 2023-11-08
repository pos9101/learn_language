package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Baekjoon 15686
 * @link https://www.acmicpc.net/problem/15686
 */
public class ChickenDelivery {
    private static int N;
    private static int M;
    private static List<int[]> chickenHouses;
    private static List<int[]> homes;
    private static boolean[] visited;
    private static int minChickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chickenHouses = new ArrayList<>();
        homes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                switch (val) {
                    case 1:
                        homes.add(new int[]{i, j});
                        break;
                    case 2:
                        chickenHouses.add(new int[]{i, j});
                        break;
                    default:
                        break;
                }
            }
        }
        visited = new boolean[chickenHouses.size()];
        findRemainChickenHouse(-1, 0);
        System.out.println(minChickenDistance);
        br.close();
    }

    private static void findRemainChickenHouse(int index, int count) {
        if (count == M) {
            int chickenDistance = 0;
            for (int[] home : homes) {
                int aHouseDistance = Integer.MAX_VALUE;
                for (int i = 0; i < chickenHouses.size(); i++) {
                    if (visited[i]) {
                        int[] chickenHouse = chickenHouses.get(i);
                        int distance = Math.abs(home[0] - chickenHouse[0]) + Math.abs(home[1] - chickenHouse[1]);
                        if (distance < aHouseDistance) aHouseDistance = distance;
                    }
                }
                chickenDistance += aHouseDistance;
            }
            if(chickenDistance < minChickenDistance) minChickenDistance = chickenDistance;
            return;
        }
        for (int i = index + 1; i < chickenHouses.size(); i++) {
            visited[i] = true;
            findRemainChickenHouse(i, count + 1);
            visited[i] = false;
        }
    }
}
