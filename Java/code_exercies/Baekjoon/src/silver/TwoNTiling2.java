package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 11727
 * @link https://www.acmicpc.net/problem/11727
 */
public class TwoNTiling2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        // not used memory[0]
        int[] memory = new int[N + 1];
        System.out.println(solveNum(memory, N));
        br.close();
    }

    //1 1
    //2 3
    //3 5
    //4 11
    //5 21
    //6 43
    //7 85
    //8 171
    private static int solveNum(int[] memory, final int N) {
        if(memory[N] != 0) return memory[N];
        switch(N) {
            case 1:
                memory[1] = 1;
                return memory[1];
            case 2:
                memory[2] = 3;
                return memory[2];
            default:
                break;

        }
        memory[N] = (solveNum(memory, N - 1) + 2 * solveNum(memory, N - 2)) % 10007;
        return memory[N];
    }
}
