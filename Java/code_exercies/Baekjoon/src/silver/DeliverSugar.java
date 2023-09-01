package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * baekjoon 2839
 * @link https://www.acmicpc.net/problem/2839
 */
public class DeliverSugar {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        System.out.print(findMinNumberOfBag(input));

        br.close();
    }

    public static int findMinNumberOfBag(int input) {
        int maxFiveNum = input / 5;

        for (int i = maxFiveNum; i >= 0; i--) {
            int leftoverSugar = input - (5 * i);
            if(leftoverSugar % 3 == 0) {
                return i + leftoverSugar / 3;
            }
        }
        return -1;
    }
}
