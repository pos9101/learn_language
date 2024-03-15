package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 5596
 * @link https://www.acmicpc.net/problem/5596
 */
public class TestGrade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int infoMinGook = Integer.parseInt(st.nextToken());
        int mathMinGook = Integer.parseInt(st.nextToken());
        int scienceMinGook = Integer.parseInt(st.nextToken());
        int englishMinGook = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int infoMansae = Integer.parseInt(st.nextToken());
        int mathMansae = Integer.parseInt(st.nextToken());
        int scienceMansae = Integer.parseInt(st.nextToken());
        int englishMansae = Integer.parseInt(st.nextToken());
        int totalMingook = infoMinGook + mathMinGook + scienceMinGook + englishMinGook;
        int totalMansae = infoMansae + mathMansae + scienceMansae + englishMansae;
        if(totalMingook >= totalMansae) System.out.println(totalMingook);
        else System.out.println(totalMansae);
        br.close();
    }
}
