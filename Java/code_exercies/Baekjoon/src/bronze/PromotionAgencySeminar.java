package bronze;

import java.io.*;

/**
 * Baekjoon 30087
 * @link https://www.acmicpc.net/problem/30087
 */
public class PromotionAgencySeminar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            bw.write(takeRoomNum(br.readLine()) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static String takeRoomNum(String lectrueName) {
        switch (lectrueName) {
            case "Algorithm":
                return "204";
            case "DataAnalysis":
                return "207";
            case "ArtificialIntelligence":
                return "302";
            case "CyberSecurity":
                return "B101";
            case "Network":
                return "303";
            case "Startup":
                return "501";
            case "TestStrategy":
            default:
                return "105";
        }
    }
}
