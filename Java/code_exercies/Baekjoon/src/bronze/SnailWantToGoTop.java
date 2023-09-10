package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 2869
 * @link https://www.acmicpc.net/problem/2869
 */
public class SnailWantToGoTop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final long A = Long.parseLong(st.nextToken());
        final long B = Long.parseLong(st.nextToken());
        final long V = Long.parseLong(st.nextToken());

        final long exceptLastDayRise = V - A;
        if(exceptLastDayRise > 0) {
            final long dayAndNightRise = A - B;
            long temp = exceptLastDayRise / dayAndNightRise;
            final long remainRise = (dayAndNightRise >= exceptLastDayRise)? 1 :
                    ((exceptLastDayRise % dayAndNightRise == 0)? temp : temp + 1) ;
            System.out.println(1 + remainRise);
        } else {
            System.out.println(1);
        }

        br.close();
    }
}
