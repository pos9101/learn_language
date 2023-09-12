package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * Baekjoon 7568
 * @link https://www.acmicpc.net/problem/7568
 */
public class QuestFrame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner(" ");

        final int N = Integer.parseInt(br.readLine());
        Human[] humans = new Human[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            final int x = Integer.parseInt(st.nextToken());
            final int y = Integer.parseInt(st.nextToken());
            humans[i] = new Human(x, y);
        }

        calculateRankingHumans(humans);

        Arrays.stream(humans).forEach(x-> sj.add(String.valueOf(x.getRanking())));
        System.out.println(sj.toString());
        br.close();
    }

    private static void calculateRankingHumans(Human[] humans) {
        for (Human human : humans) {
            human.setRanking((int) ((Arrays.stream(humans)
                                .filter(x -> !x.equals(human)
                                        && x.getWeight() > human.getWeight()
                                        && x.getHeight() > human.getHeight())
                                .count()) + 1));
        }
    }

    public static class Human {
        private final int weight;
        private final int height;
        private int ranking;

        public Human(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }

        public int getHeight() {
            return height;
        }

        public int getRanking() {
            return ranking;
        }

        public void setRanking(int ranking) {
            this.ranking = ranking;
        }
    }
}

