package silver;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Baekjoon 1620
 * @link https://www.acmicpc.net/problem/1620
 */
public class ImPokemonMasterDasom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> pokeIdDex = new HashMap<>();
        HashMap<String, Integer> pokeNameDex = new HashMap<>();


        for (int num = 1; num <= N; num++) {
            String name = br.readLine();
            pokeIdDex.put(num, name);
            pokeNameDex.put(name, num);
        }

        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            if(pokeNameDex.get(question) != null) {
                bw.write(pokeNameDex.get(question)+ "\n");
            } else {
                bw.write(pokeIdDex.get(Integer.parseInt(question)) + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
