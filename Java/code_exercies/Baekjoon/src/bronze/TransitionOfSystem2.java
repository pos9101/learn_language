package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 11005
 * @link https://www.acmicpc.net/problem/11005
 */
public class TransitionOfSystem2 {
    static final char digits[] = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'A' , 'B' ,
            'C' , 'D' , 'E' , 'F' , 'G' , 'H' ,
            'I' , 'J' , 'K' , 'L' , 'M' , 'N' ,
            'O' , 'P' , 'Q' , 'R' , 'S' , 'T' ,
            'U' , 'V' , 'W' , 'X' , 'Y' , 'Z'
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        System.out.println(transition(N, B));
        br.close();
    }

    private static String transition(int value, int formation) {
//        return Integer.toString(value, formation).toUpperCase();
        StringBuffer sb = new StringBuffer();
        while (value >= formation) {
            sb.append(digits[value % formation]);
            value /= formation;
        }
        sb.append(digits[value]);
        return sb.reverse().toString();
    }
}
