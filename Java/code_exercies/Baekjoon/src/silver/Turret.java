package silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 1002
 * @link https://www.acmicpc.net/problem/1002
 */
public class Turret {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            bw.write(solveNumOfLocation(x1, y1, r1, x2, y2, r2) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int solveNumOfLocation(int x1, int y1, int r1, int x2, int y2, int r2) {
        if (x1 == x2 && y1 == y2) {
            if (r1 == r2) return -1;
            return 0;
        }
        int diagonalSquare = (int) Math.pow(r1 + r2, 2);
        int turretDistanceSquare = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if(diagonalSquare == turretDistanceSquare) return 1;
        if(diagonalSquare < turretDistanceSquare) return 0;
        int diagonalMinusSquare = (int) Math.pow(r1 - r2, 2);
        if(diagonalMinusSquare > turretDistanceSquare) return 0;
        if(diagonalMinusSquare == turretDistanceSquare) return 1;
        return 2;
    }
}
