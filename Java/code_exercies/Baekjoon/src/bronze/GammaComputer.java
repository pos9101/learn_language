package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 30402
 * @link https://www.acmicpc.net/problem/30402
 */
public class GammaComputer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = null;
        for (int i = 0; i < 15; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            if (answer == null) {
                for (int j = 0; j < 15; j++) {
                    char pixel = st.nextToken().charAt(0);
                    switch (pixel) {
                        case 'w':
                            answer = "chunbae";
                            break;
                        case 'b':
                            answer = "nabi";
                            break;
                        case 'g':
                            answer = "yeongcheol";
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
}
