package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 * Baekjoon 1676
 * @link https://www.acmicpc.net/problem/1676
 */
public class NumOfZeroFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        //find two and five ( 2 * 5  == 10 )
        int numOfTwo = IntStream.rangeClosed(1, N).filter(x -> x % 2 == 0)
                .reduce(0, (total, val) -> total + countDivideTwo(val));
        int numOfFive = IntStream.rangeClosed(1, N).filter(x -> x % 5 == 0)
                .reduce(0, (total, val) -> total + countDivideFive(val));

        System.out.println(numOfFive > numOfTwo ? numOfTwo : numOfFive);
        br.close();
    }

    public static int countDivideFive(int num) {
        if(num % 5 != 0) {
            return 0;
        }
        return 1 + countDivideFive(num / 5);
    }

    public static int countDivideTwo(int num) {
        if(num % 2 != 0) {
            return 0;
        }
        return 1 + countDivideFive(num / 2);
    }

}
