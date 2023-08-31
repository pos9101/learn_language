import java.io.*;
import java.util.StringTokenizer;

public class AsciiCode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        bw.write(String.valueOf(changeCharToInt(st.nextToken().charAt(0))));
        bw.flush();

        br.close();
        bw.close();
    }

    public static int changeCharToInt(char c) {
        int num = c;
        return num;
    }
}
