package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 1541
 * @link https://www.acmicpc.net/problem/1541
 */
public class LostBrace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int sum = 0;
        String[] splitMinus = line.split("-");
        if(splitMinus.length == 1) {
            String[] splitPlus = splitMinus[0].split("\\+");
            for (String plus : splitPlus) {
                sum += Integer.parseInt(plus);
            }
        } else {
            String[] splitZero = splitMinus[0].split("\\+");
            for (String s : splitZero) {
                sum += Integer.parseInt(s);
            }
            for (int i = 1; i < splitMinus.length; i++) {
                String[] split = splitMinus[i].split("\\+");
                int temp = 0;
                for (int j = 0; j < split.length; j++) {
                    temp += Integer.parseInt(split[j]);
                }
                sum -= temp;
            }
        }
        System.out.println(sum);
        br.close();
    }
}
