package silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * baekjoon 2751
 * @link https://www.acmicpc.net/problem/2751
 */
public class ArrangeNumber2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        List<Integer> numList = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            numList.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(numList);
        for (Integer aNum : numList) {
            bw.write(aNum + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
