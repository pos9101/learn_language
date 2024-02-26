package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 5543
 * @link https://www.acmicpc.net/problem/5543
 */
public class SanggnNald {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int sangdukBurger = Integer.parseInt(br.readLine());
        final int jungdukBurger = Integer.parseInt(br.readLine());
        final int hadukBurger = Integer.parseInt(br.readLine());
        final int colaPrice = Integer.parseInt(br.readLine());
        final int ciderPrice = Integer.parseInt(br.readLine());
        System.out.println(Math.min(Math.min(sangdukBurger, jungdukBurger), hadukBurger)
                + Math.min(colaPrice, ciderPrice) - 50);
        br.close();
    }
}
