package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 5532
 * @link https://www.acmicpc.net/problem/5532
 */
public class VacationHomework {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int koreanDay = A % C == 0 ? A / C : A / C + 1 ;
        int mathDay = B % D == 0 ? B / D : B / D + 1;
        int answer = Math.min((L - koreanDay), (L - mathDay));
        System.out.println(answer);
        br.close();
    }
}
