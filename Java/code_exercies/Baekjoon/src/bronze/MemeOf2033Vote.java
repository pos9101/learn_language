package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Baekjoon 29731
 * @link https://www.acmicpc.net/problem/29731
 */
public class MemeOf2033Vote {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        Set<String> messages = new HashSet<>();
        messages.add("Never gonna give you up");
        messages.add("Never gonna let you down");
        messages.add("Never gonna run around and desert you");
        messages.add("Never gonna make you cry");
        messages.add("Never gonna say goodbye");
        messages.add("Never gonna tell a lie and hurt you");
        messages.add("Never gonna stop");

        boolean answer = false;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            if (!messages.contains(line)) {
                answer = true;
                break;
            }
        }
        System.out.println(answer ? "Yes" : "No");
        br.close();
    }
}
