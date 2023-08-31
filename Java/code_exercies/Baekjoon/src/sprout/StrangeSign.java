package sprout;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 *  Baekjoon 15964
 *  이상한 기호
 */
public class StrangeSign {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long inputA = Long.parseLong(st.nextToken());
        long inputB = Long.parseLong(st.nextToken());

        bw.write(String.valueOf(calculateAt(inputA, inputB)));
        bw.flush();

        br.close();
        bw.close();
    }

    /**
     * Calculate (A + B) * (A - B)
     * @param a
     * @param b
     * @return
     */
    public static BigInteger calculateAt(long a, long b) {
        return BigInteger.valueOf((a + b) * (a - b));
    }

}
