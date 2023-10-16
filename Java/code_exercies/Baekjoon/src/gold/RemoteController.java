package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class RemoteController {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        final int N = Integer.parseInt(line);
        final int M = Integer.parseInt(br.readLine());
        boolean[] brokenNum = new boolean[10];
        int[] allNumber = new int[1000001];
        if(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                brokenNum[Integer.parseInt(st.nextToken())] = true;
            }
        }
        if(N == 100 || M == 10) {
            System.out.println(Math.abs(N - 100));
        } else {
            for (int i = 0; i < allNumber.length; i++) {
                if(isPossible(brokenNum, i)) {
                    allNumber[i] = Math.min(Math.abs(N - i) + String.valueOf(i).length(), Math.abs(N - 100));
                }
            }
            System.out.println(Arrays.stream(allNumber).filter(x -> x != 0).min().getAsInt());
        }
        br.close();
    }

    private static boolean isPossible(boolean[] brokenNum, int num) {
        String numString = String.valueOf(num);
        for (int i = 0; i < numString.length(); i++) {
            if(brokenNum[Character.getNumericValue(numString.charAt(i))]) {
                return false;
            }
        }
        return true;
    }
}
