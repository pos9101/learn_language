package sprout;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 10807
 * @link https://www.acmicpc.net/problem/10807
 */
public class CountNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] array = new int[num];
        for(int i = 0; i < num; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int findNum = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(findNumCount(array, findNum)));

        br.close();
        bw.close();
    }

    public static int findNumCount(int[] array, int findNum) {
        int count = 0;
        for (int i : array) {
            if(i == findNum)
                count++;
        }
        return count;
    }
}
