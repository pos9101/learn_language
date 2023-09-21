package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Baekjoon 1931
 * @link https://www.acmicpc.net/problem/1931
 */
public class AllocateOfConferenceRoom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        //[0]: start, [1]: end
        long[][] conferencesArray = new long[N][2];
        initializeArray(N, br, conferencesArray);

        System.out.println(solveMaxConferences(conferencesArray));
        br.close();
    }

    private static long solveMaxConferences(long[][] conferenceArray) {
        //[0]: start, [1]: end
        Stack<long[]> bookConferences = new Stack<>();
        for (long[] reservation : conferenceArray) {
            if(bookConferences.isEmpty()) {
                bookConferences.push(new long[]{reservation[0], reservation[1]});
            } else {
                long bookedEndTime = bookConferences.peek()[1];
                if(reservation[0] >= bookedEndTime) {
                    bookConferences.push(new long[]{reservation[0], reservation[1]});
                } else if(reservation[1] < bookedEndTime) {
                    bookConferences.pop();
                    bookConferences.push(new long[]{reservation[0], reservation[1]});
                }
            }
        }

        return bookConferences.size();
    }

    private static void initializeArray(int N, BufferedReader br, long[][] conferencesArray) throws IOException {
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            conferencesArray[i] = new long[]{start, end};
        }
        Arrays.sort(conferencesArray,
                Comparator.comparingLong((long[] arr) -> arr[0]).thenComparingLong(arr -> arr[1]));
    }
}
