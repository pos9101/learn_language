package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 2941
 * @link https://www.acmicpc.net/problem/2941
 */
public class HrvatskaAlphabet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int count = 0;
        int i = 0;
        line = line.replace("dz=", "3");
        line = line.replace("c=", "1");
        line = line.replace("c-", "2");
        line = line.replace("d-", "4");
        line = line.replace("lj", "5");
        line = line.replace("nj", "6");
        line = line.replace("s=", "7");
        line = line.replace("z=", "8");
        System.out.println(line.length());
        br.close();
    }
}
