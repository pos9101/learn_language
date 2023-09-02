package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Baekjoon 3052
 * @link https://www.acmicpc.net/problem/3052
 */
public class Remainder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> remainderSet = new HashSet<>();

        for(int i = 0; i< 10; i++) {
            remainderSet.add(Integer.parseInt(br.readLine()) % 42);
        }
        
        System.out.println(remainderSet.size());

        br.close();
    }
}
