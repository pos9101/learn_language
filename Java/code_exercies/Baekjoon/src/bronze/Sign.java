package bronze;

import java.io.*;
import java.math.BigInteger;

/**
 * Baekjoon 1247
 * @link https://www.acmicpc.net/problem/1247
 */
public class Sign {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 3; i++) {
            final int N = Integer.parseInt(br.readLine());
            BigInteger val = new BigInteger("0");
            for (int j = 0; j < N; j++) {
                val = val.add(new BigInteger(br.readLine()));
            }
            int sign = val.compareTo(new BigInteger("0"));
            if (sign > 0) {
                bw.write("+\n");
            } else if(sign < 0) {
                bw.write("-\n");
            } else {
                bw.write("0\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
