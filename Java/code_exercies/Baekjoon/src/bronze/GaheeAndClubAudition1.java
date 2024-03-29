package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 30794
 * @link https://www.acmicpc.net/problem/30794
 */
public class GaheeAndClubAudition1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int lv = Integer.parseInt(st.nextToken());
        String grade = st.nextToken();
        int score = 0;
        switch(grade){
            case "miss":
                score = 0;
                break;
            case "bad":
                score = 200;
                break;
            case "cool":
            score = 400;
                break;
            case "great":
            score = 600;
                break;
            case "perfect":
            default:
            score = 1000;
                break;
        }
        System.out.println(lv * score);
        br.close();
    }
}
