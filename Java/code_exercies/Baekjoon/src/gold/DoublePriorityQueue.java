package gold;

import java.io.*;
import java.util.*;

/**
 * Baekjoon 7662
 *
 * @link https://www.acmicpc.net/problem/7662
 */
public class DoublePriorityQueue {

    private static PriorityQueue<Integer> queueMin = new PriorityQueue<>();
    private static PriorityQueue<Integer> queueMax = new PriorityQueue<>(Comparator.reverseOrder());
    private static Map<Integer, Integer> queueMap = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            queueMin.clear();
            queueMax.clear();
            queueMap.clear();
            int k = Integer.parseInt(br.readLine());
            for (int calNum = 0; calNum < k; calNum++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String command = st.nextToken();
                int commandNum = Integer.parseInt(st.nextToken());
                switch (command) {
                    case "D":
                        if (!queueMap.isEmpty()) {
                            if (commandNum == 1) {
                                removeData(queueMax);
                            } else { // -1
                                removeData(queueMin);
                            }
                        }
                        break;
                    case "I":
                    default:
                        queueMin.offer(commandNum);
                        queueMax.offer(commandNum);
                        queueMap.put(commandNum, queueMap.getOrDefault(commandNum, 0) + 1);
                        break;
                }
            }
            if (!queueMap.isEmpty()) {
                int max = removeData(queueMax);
                bw.write(max + " ");
                if(!queueMap.isEmpty()) {
                    int min = removeData(queueMin);
                    bw.write(min +"\n");
                } else {
                    bw.write(max + "\n");
                }
            } else {
                bw.write("EMPTY\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int removeData(PriorityQueue<Integer> queue) {
        int val = queue.poll();
        int count = queueMap.getOrDefault(val, 0);
        while(count == 0) {
            val = queue.poll();
            count = queueMap.getOrDefault(val, 0);
        }
        if (count == 1) {
            queueMap.remove(val);
        } else {
            queueMap.put(val, count - 1);
        }
        return val;
    }
}
