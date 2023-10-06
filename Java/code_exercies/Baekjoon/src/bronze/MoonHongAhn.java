package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MoonHongAhn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] stones = new int[101];
        final int P = Integer.parseInt(br.readLine());
        final int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            if(st.nextToken().equals("R")) {
                for (int j = num + 1; j <= 100; j++) {
                    ++stones[j];
                }
            } else {
                for (int j = num - 1; j >= 1; j--) {
                    ++stones[j];
                }
            }
        }
        int blue = 0;
        int red = 0;
        int green = 0;
        for (int i = 1; i <= 100; i++) {
            switch(stones[i] % 3) {
                case 0:
                    ++blue;
                    break;
                case 1:
                    ++red;
                    break;
                case 2:
                default:
                    ++green;
                    break;
            }
        }
        System.out.println(String.format("%.2f", P * blue / 100f));
        System.out.println(String.format("%.2f", P * red / 100f));
        System.out.println(String.format("%.2f", P * green / 100f));
        br.close();
    }
}
