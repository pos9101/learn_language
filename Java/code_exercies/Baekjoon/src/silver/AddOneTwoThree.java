package silver;

import java.io.*;

/**
 * Baekjoon 9095
 * @link https://www.acmicpc.net/problem/9095
 */
public class AddOneTwoThree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        int[] memory = new int[11];
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(calculateAnswer(memory, n) +"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    //1 - > 1
    //2 - > 2   11  2
    //3 - > 4   111 12 21 3
    //4 - > 7   1111 112 121 211 22 31 13
    //5 - > 13  11111 1112 1121 1211 2111 122 212 221 32 23 311 131 113
    //6 - > 24  111111 11112 11121 11211 12111 21111 1122 1212 2112 2121
    //          2211 222 1113 1131 1311 3111 33 123 213 231
    //          132 312
    //7 - > 44
    //10 -> 274
    private static int calculateAnswer(int[] memory, int n) {
        if(memory[n] != 0) {
            return memory[n];
        }
        switch (n) {
            case 1:
                memory[1] = 1;
                return memory[1];
            case 2:
                memory[2] = 2;
                return memory[2];
            case 3:
                memory[3] = 4;
                return memory[3];
            default:
                memory[n] = calculateAnswer(memory, n -1) + calculateAnswer(memory, n -2) + calculateAnswer(memory, n -3);
                return memory[n];
        }
    }
}
