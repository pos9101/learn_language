package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoNTiling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] memory = new int[N < 3? 4 : N + 1];
        for (int i = 1; i <= 3; i++) {
            memory[i] = i;
        }
        System.out.println(solveAnswer(memory, N));
        br.close();
    }

    //1 -> 1
    //2 -> 2
    //3 -> 3
    //4 -> 5
    //5 -> 8
    //6 -> 13
    //7 -> 21
    //8 -> 34
    //9 -> 55
    private static int solveAnswer(int[] memory, final int N) {
        if(memory[N] != 0) {
            return memory[N];
        }
        memory[N] = (solveAnswer(memory, N - 1) + solveAnswer(memory, N - 2));
        if(memory[N] > 10007) {
            memory[N] %= 10007;
        }
        return memory[N];
    }
}
