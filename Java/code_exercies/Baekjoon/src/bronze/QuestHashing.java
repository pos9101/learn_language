package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Baekjoon 15829
 * @link https://www.acmicpc.net/problem/15829
 */
public class QuestHashing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int L = Integer.parseInt(br.readLine());
        final int r = 31;
        final long M = 1234567891;
        String line = br.readLine();

        BigInteger[] powMemory = new BigInteger[50];
        for (int i = 0; i < 50; i++) {
            powMemory[i] = new BigInteger("0");
        }

        int[] originNumArray = new int[L];
        for (int i = 0; i < L; i++) {
            char c = line.charAt(i);
            originNumArray[i] = charToOriginNum(c);
        }

        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < originNumArray.length; i++) {
            sum = sum.add(pow(powMemory, r, i).multiply(BigInteger.valueOf(originNumArray[i])));
        }

        System.out.println(sum.remainder(BigInteger.valueOf(M)));

        br.close();
    }

    private static int charToOriginNum(char c) {
        return c -96;
    }

    public static BigInteger pow(BigInteger[] memory, int base, int n) {
        if(!memory[n].equals(BigInteger.valueOf(0L))) {
            return memory[n];
        }
        if(n == 0) {
            memory[0] = new BigInteger("1");
            return memory[0];
        }
        memory[n] = memory[n].add(pow(memory, base, n - 1).multiply(BigInteger.valueOf(base)));
        return memory[n];
    }
}
