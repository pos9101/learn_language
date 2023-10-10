package silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Baekjoon 9375
 * @link https://www.acmicpc.net/problem/9375
 */
public class FashionKingHaeBinShin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> clothesMap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String clothesType = st.nextToken();
                if(clothesMap.containsKey(clothesType)) {
                    clothesMap.put(clothesType, clothesMap.get(clothesType) + 1);
                } else {
                    clothesMap.put(clothesType, 1);
                }
            }
            Object[] numArray = clothesMap.values().stream().toArray();
            int combinations = 1;
            for (Object o : numArray) {
                combinations *= (Integer)o + 1; //1 means not wearing part.
            }
            --combinations; //not clothes
            bw.write(combinations + "\n");

        }
        bw.flush();
        br.close();
        bw.close();
    }
}
