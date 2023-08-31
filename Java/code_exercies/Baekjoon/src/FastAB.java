import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 15552
 * 빠른 A+B
 * @link https://www.acmicpc.net/problem/15552
 */
public class FastAB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int testNum = Integer.parseInt(input);

        for(int i = testNum; i > 0; i--){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            bw.write(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();

    }
}