package silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 1920
 * @link https://www.acmicpc.net/problem/1920
 */
public class FindNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(br.readLine());
        long[] nArray = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nArray[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(nArray);

        final int M = Integer.parseInt(br.readLine());
        long[] mArray = new long[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            mArray[i] = Long.parseLong(st.nextToken());
        }

        //Search with Logic
        for (long value : mArray) {
            bw.write(searchBinary(nArray, value, 0 , nArray.length -1) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    /** @return 1 -> true , 0 -> false */
    private static int searchBinary(long[] array, long value, int first, int last) {
        if(first > last) {
            return 0;
        }
        int mid = (first + last) / 2;
        if (array[mid] == value) {
            return 1;
        } else if(array[mid] > value) {
            return searchBinary(array, value, first, mid - 1);
        } else {
            return searchBinary(array, value, mid + 1, last);
        }
    }
}
