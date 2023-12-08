package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ByeFindDust {

    static int[][] dustMap;
    static int R;
    static int C;
    static AirInfo[] airCleaner = new AirInfo[2];
    static ArrayList<AirInfo> upperCleaner = new ArrayList<>();
    static ArrayList<AirInfo> lowerCleaner = new ArrayList<>();
    static int[][] spreadDust = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        final int T = Integer.parseInt(st.nextToken());
        dustMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                dustMap[i][j] = Integer.parseInt(st.nextToken());
                if (dustMap[i][j] == -1) {
                    if(airCleaner[0] == null) {
                        airCleaner[0] = new AirInfo(i, j);
                    } else if (airCleaner[1] == null) {
                        airCleaner[1] = new AirInfo(i, j);
                    }
                }
            }
        }
        initAirCleaner();
        for (int i = 0; i < T; i++) {
            spreadDust();
            windCleaner();
        }

        OptionalInt answer = Arrays.stream(dustMap)
                .flatMapToInt(rowArray -> Arrays.stream(rowArray))
                .filter(dusts -> dusts != -1)
                .reduce((total, dust) -> total + dust);
        System.out.println(answer.getAsInt());
        br.close();
    }

    private static void initAirCleaner() {
        initializeUpper();
        initializeLower();
    }

    private static void spreadDust() {
        Queue<DustInfo> queue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (dustMap[i][j] > 0) {
                    int val = dustMap[i][j];
                    queue.add(new DustInfo(i, j, val));
                }
            }
        }
        clearDust();
        while(!queue.isEmpty()){
            DustInfo poll = queue.poll();
            int spreadCount = 0;
            for (int[] dust : spreadDust) {
                int spreadX = poll.row + dust[0];
                int spreadY = poll.col + dust[1];

                if(canSpread(spreadX, spreadY)) {
                    dustMap[spreadX][spreadY] += poll.quantity / 5;
                    ++spreadCount;
                }
            }
            dustMap[poll.row][poll.col] += poll.quantity - poll.quantity / 5 * spreadCount;
        }
    }

    private static boolean canSpread(int spreadX, int spreadY) {
        for (int i = 0; i < airCleaner.length; i++) {
            if(spreadX == airCleaner[i].row && spreadY == airCleaner[i].col) return false;
        }
        return spreadX >= 0 && spreadY >= 0 && spreadX < R && spreadY < C;
    }

    private static void clearDust() {
        for (int i = 0; i < R; i++) {
            Arrays.fill(dustMap[i], 0);
        }
        for (AirInfo dustInfo : airCleaner) {
            dustMap[dustInfo.row][dustInfo.col] = -1;
        }
    }

    private static void initializeUpper() {
        int x = airCleaner[0].row;
        int y = airCleaner[0].col;
        while(x > 0) {
            --x;
            upperCleaner.add(new AirInfo(x, y));
        }
        while(y < C - 1){
            ++y;
            upperCleaner.add(new AirInfo(x, y));
        }
        while(x < airCleaner[0].row) {
            ++x;
            upperCleaner.add(new AirInfo(x, y));
        }
        while (y > 1) {
            --y;
            upperCleaner.add(new AirInfo(x, y));
        }
    }

    private static void initializeLower() {
        int x = airCleaner[1].row;
        int y = airCleaner[1].col;
        while(x < R - 1) {
            ++x;
            lowerCleaner.add(new AirInfo(x, y));
        }
        while(y < C - 1){
            ++y;
            lowerCleaner.add(new AirInfo(x, y));
        }
        while(x > airCleaner[1].row) {
            --x;
            lowerCleaner.add(new AirInfo(x, y));
        }
        while (y > 1) {
            --y;
            lowerCleaner.add(new AirInfo(x, y));
        }
    }

    private static void windCleaner() {
        circulateWind(upperCleaner);
        circulateWind(lowerCleaner);
    }

    private static void circulateWind(ArrayList<AirInfo> cleaner) {
        int lastRow = airCleaner[0].row;
        int lastCol = airCleaner[0].col;
        for (AirInfo airInfo : cleaner) {
            int row = airInfo.row;
            int col = airInfo.col;
            if(dustMap[lastRow][lastCol] != -1) {
                dustMap[lastRow][lastCol] = dustMap[row][col];
            }
            lastRow = row;
            lastCol = col;
        }
        dustMap[lastRow][lastCol] = 0;
    }

    static class DustInfo {
        int row;
        int col;
        int quantity;

        public DustInfo(int row, int col, int quantity) {
            this.row = row;
            this.col = col;
            this.quantity = quantity;
        }
    }

    static class AirInfo {
        int row;
        int col;

        public AirInfo(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
