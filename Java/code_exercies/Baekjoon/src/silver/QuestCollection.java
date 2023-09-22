package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 11723
 * @link https://www.acmicpc.net/problem/11723
 */
public class QuestCollection {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        final int M = Integer.parseInt(br.readLine());
        boolean[] collection = new boolean[21];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int num = -1;
            switch (command) {
                case "all":
                case "empty":
                    break;
                default:
                    num = Integer.parseInt(st.nextToken());
                    break;
            }
            sb.append(executeCommand(collection, command, num));
        }
        System.out.println(sb.toString());
        br.close();
    }

    private static String executeCommand(boolean[] collection, String command, int num) {
        switch(command) {
            case "add":
                if(!collection[num]) {
                    collection[num] = true;
                }
                break;
            case "remove":
                if(collection[num]) {
                    collection[num] = false;
                }
                break;
            case "check":
                if(collection[num]) {
                    return "1\n";
                } else {
                    return "0\n";
                }
            case "toggle":
                if(collection[num]) {
                    collection[num] = false;
                } else {
                    collection[num] = true;
                }
                break;
            case "empty":
                Arrays.fill(collection, false);
                break;
            case "all":
            default:
                Arrays.fill(collection, true);
                break;
        }
        return "";
    }
}
