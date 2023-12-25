package bronze;

import java.io.*;
import java.math.BigInteger;

/**
 * Baekjoon 30664
 * @link https://www.acmicpc.net/problem/30664
 */
public class LoteriaFalha {
    static BigInteger fourtyTwo = new BigInteger("42");
    static BigInteger zero = new BigInteger("0");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            BigInteger n = new BigInteger(br.readLine());
            if(n.equals(zero)){
                break;
            }
            if(n.remainder(fourtyTwo).equals(zero)) {
                bw.write("PREMIADO\n");
            } else {
                bw.write("TENTE NOVAMENTE\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
