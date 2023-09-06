package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * Baekjoon 18111
 * @link https://www.acmicpc.net/problem/18111
 */
public class Minecraft {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());

        /** num of blocks from 0 ~ 256 in height */
        int[] blockNumArray = new int[257];
        for (int i = 0; i < N; i++) {
            StringTokenizer row = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(row.nextToken());
                blockNumArray[height]++;
            }
        }
        final int MAX = findMax(blockNumArray);
        final int MIN = findMin(blockNumArray);
        final boolean isFlat = (MIN == MAX) ? true : false;

        int[] timeNumArray = new int [257];

        final int minTime;
        final int highestHeight;
        if(!isFlat) {
            IntStream.rangeClosed(MIN, MAX).forEach(i -> timeNumArray[i] = calculateTimeSpent(blockNumArray, i, B, MIN, MAX));
            minTime = Arrays.stream(timeNumArray).parallel().filter(value -> value != 0).min().getAsInt();
            highestHeight = IntStream.range(0, timeNumArray.length).filter(i -> Objects.equals(timeNumArray[i], minTime)).max().getAsInt();
        } else {
            minTime = 0;
            highestHeight = MAX;
        }

        System.out.println(minTime + " " + highestHeight);

        br.close();
    }

    /** return time to make in height */
    private static int calculateTimeSpent(int[] blockNumArray, final int HEIGHT, int remainBlocks, final int MIN, final int MAX) {
        if (MIN == MAX) {
            return 0;
        }
        int lostBlock = IntStream.rangeClosed(MIN, MAX)
                .filter(p -> (p < HEIGHT)).reduce(0, (result, val) -> result + ((HEIGHT - val) * blockNumArray[val]));
        int takeBlock = IntStream.rangeClosed(MIN, MAX)
                .filter(p -> (p > HEIGHT)).reduce(0, (result, val) -> result + ((val - HEIGHT) * blockNumArray[val]));

        if(remainBlocks + takeBlock - lostBlock  < 0 ) {
            return 0;
        } else {
            return lostBlock + (takeBlock * 2);
        }
    }

    private static int findMin(int[] blockNumArray) {
        return IntStream.range(0, blockNumArray.length)
                .filter(i -> !Objects.equals(blockNumArray[i], 0))
                .findFirst().getAsInt();
    }

    private static int findMax(int[] blockNumArray) {
        return IntStream.range(0, blockNumArray.length)
                .filter(i -> !Objects.equals(blockNumArray[i], 0))
                .max().getAsInt();
    }


}
