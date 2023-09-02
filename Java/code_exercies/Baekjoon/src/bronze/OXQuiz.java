package bronze;

import java.io.*;

/**
 * Baekjoon 8958
 * @link https://www.acmicpc.net/problem/8958
 */
public class OXQuiz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numOfTestcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < numOfTestcase; i++) {
            String line = br.readLine();
            int point = 0;
            int record = 0;
            int quizNum = line.length();
            for(int j = 0; j < quizNum; j++){
                char correct = line.charAt(j);
                switch(correct) {
                    case 'O':
                        record += ++point;
                        break;
                    case 'X':
                    default:
                        point = 0;
                        break;
                }
            }
            bw.write(record + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
