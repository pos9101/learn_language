package bronze;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

/**
 * Baekjoon 11948
 * @link https://www.acmicpc.net/problem/11948
 */
public class LectureSelect {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int A = Integer.parseInt(br.readLine());
        final int B = Integer.parseInt(br.readLine());
        final int C = Integer.parseInt(br.readLine());
        final int D = Integer.parseInt(br.readLine());
        final int E = Integer.parseInt(br.readLine());
        final int F = Integer.parseInt(br.readLine());
        int min = Math.min(Math.min(A, B), Math.min(C, D));
        int firstSelect = A + B + C + D - min;
        int secondSelect = Math.max(E, F);
        System.out.println(firstSelect + secondSelect);
        br.close();
    }
}
