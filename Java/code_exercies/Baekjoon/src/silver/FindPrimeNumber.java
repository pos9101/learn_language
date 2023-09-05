package silver;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * Baekjoon 1929
 * @link https://www.acmicpc.net/problem/1929
 */
public class FindPrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        /**
         *  PrimeNumber : false,
         *  Not PrimeNumber : true
         */
        boolean[] isNotPrimeNum = new boolean[n + 1];
        int rootN = (int) Math.sqrt(n + 1);
        IntStream.range(1, rootN + 1).forEach(x -> changeNonPrimeNumTimesToTrue(isNotPrimeNum, x));

        for (int i = m; i <= n; i++) {
            if(isNotPrimeNum[i] == false) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void changeNonPrimeNumTimesToTrue(boolean[] array, int num) {
        if(num == 1) {
            array[1] = true;
            return;
        }
        //if isNotPrimeNumber, return
        if (isPrimeNumber(array, num)) {
            for (int i = num*num; i < array.length; i += num) {
                array[i] = true;
            }
        }


    }

    private static boolean isPrimeNumber(boolean[] array, int num) {
        //load isn't prime number array
        if(array[num] == true) {
            return false;
        }
        for (int i = num - 1; i >= 2; i--) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
