package bronze;

import java.io.*;

/**
 * Baekjoon 1264
 * @link https://www.acmicpc.net/problem/1264
 */
public class NumOfMoum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String line = br.readLine();
            if(line.equals("#")) break;
            int num = 0;
            for (int i = 0; i < line.length(); i++) {
                if (isMoum(line.charAt(i))) ++num;
            }
            bw.write(num + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean isMoum(char c) {
        switch (c) {
            case 'a': case 'A':
            case 'e': case 'E':
            case 'i': case 'I':
            case 'o': case 'O':
            case 'u': case 'U':
                return true;
            default:
                return false;
        }
    }
}
