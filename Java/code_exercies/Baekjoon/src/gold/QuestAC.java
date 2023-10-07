package gold;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * Baekjoon 5430
 * @link https://www.acmicpc.net/problem/5430
 */
public class QuestAC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            line = line.substring(1, line.length() - 1);
            Deque<Integer> deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(line, ",");
            boolean isFront = true;
            boolean occurError = false;
            for (int j = 0; j < n; j++) deque.addLast(Integer.parseInt(st.nextToken()));
            for (int j = 0; j < command.length(); j++) {
                if(command.charAt(j) == 'R') {
                    isFront = !isFront;
                } else {
                    if(deque.isEmpty()) {
                        bw.write("error\n");
                        occurError = true;
                        break;
                    }
                    if(isFront) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }
            if(!occurError) {
                bw.write("[");
                StringJoiner sj = new StringJoiner(",");
                while(!deque.isEmpty()) {
                    if(isFront) {
                        sj.add(String.valueOf(deque.pollFirst()));
                    } else {
                        sj.add(String.valueOf(deque.pollLast()));
                    }
                }
                bw.write(sj.toString());
                bw.write("]\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
