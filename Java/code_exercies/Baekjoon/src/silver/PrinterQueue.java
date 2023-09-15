package silver;

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Baekjoon 1966
 * @link https://www.acmicpc.net/problem/1966
 */
public class PrinterQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int NUM_OF_TESTCASE = Integer.parseInt(br.readLine());
        for (int i = 0; i < NUM_OF_TESTCASE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            LinkedList<Document> queueMemory = new LinkedList<>();
            final int N = Integer.parseInt(st.nextToken());
            final int M = Integer.parseInt(st.nextToken());
            StringTokenizer documents = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int priority = Integer.parseInt(documents.nextToken());
                queueMemory.add(new Document(j, priority));
            }
            bw.write(findRanking(queueMemory, M) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int findRanking(LinkedList<Document> queue, final int id) {
        int ranking = 0;
        while(!queue.isEmpty()) {
            int maxPriority = queue.stream().max(Comparator.comparing(Document::getPriority)).get().getPriority();
            if(queue.peekFirst().getPriority() == maxPriority) {
                ++ranking;
                Document document = queue.pollFirst();
                if(document.getId() == id) {
                    break;
                }
            } else {
                queue.add(queue.pollFirst());
            }
        }
        return ranking;
    }

    private static class Document {
        private int id;
        private int priority;

        private Document(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }

        public int getId() {
            return id;
        }

        public int getPriority() {
            return priority;
        }
    }
}
