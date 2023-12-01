package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Baekjoon 11444
 * @link https://www.acmicpc.net/problem/11444
 */
public class FibonacciNum6 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());
        // ( 1 1 ) (Fn  )  =  (Fn+1)   ( 1 1 )^ k  (F1)  =  (Fk+1)
        // ( 1 0 ) (Fn-1)  =  (Fn  )   ( 1 0 )     (F0)  =  (Fk)
        long[][] matrix = new long[][]{{1, 1}, {1, 0}};
        long[][] result = new long[][]{{1, 0}, {0, 1}};
        while (n.compareTo(BigInteger.ZERO) == 1) {
            if (n.remainder(BigInteger.TWO).equals(BigInteger.ONE)) {
                result = multiplyMatrix(matrix, result);
            }
            matrix = multiplyMatrix(matrix, matrix);
            n = n.divide(BigInteger.TWO);
        }
        System.out.println(result[1][0]);
        br.close();
    }

    //just use 2 * 2 matrix
    private static long[][] multiplyMatrix(long[][] a, long[][] b) {
        long[][] matrix = new long[2][2];
        matrix[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % 1000000007;
        matrix[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % 1000000007;
        matrix[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % 1000000007;
        matrix[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % 1000000007;
        return matrix;
    }
}
