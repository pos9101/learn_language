package silver;

import java.io.*;

/**
 * Baekjoon 1927
 * @link https://www.acmicpc.net/problem/1927
 */
public class MinHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int N = Integer.parseInt(br.readLine());
        //not use minHeap[0]
        long[] minHeap = new long[100001];
        int sizeOfHeap = 0;
        for (int i = 0; i < N; i++) {
            long val = Long.parseLong(br.readLine());
            if(val == 0) {
                bw.write(minHeap[1] + "\n");
                minHeap[1] = minHeap[sizeOfHeap];
                if(sizeOfHeap != 0) {
                    minHeap[sizeOfHeap] = 0;
                    --sizeOfHeap;
                }
                int index = 1;
                while(index * 2 <= 100000 && minHeap[index * 2] != 0) {
                    int minChildIndex = index * 2;
                    if(minHeap[index * 2 + 1] != 0 && minHeap[index * 2 + 1] < minHeap[minChildIndex]) {
                        minChildIndex = index * 2 + 1;
                    }
                    if(minHeap[minChildIndex] < minHeap[index]) {
                        swap(minHeap, minChildIndex, index);
                        index = minChildIndex;
                    } else {
                        break;
                    }
                }
            } else {
                int index = ++sizeOfHeap;
                minHeap[index] = val;
                while (index / 2 >= 1 && minHeap[index] < minHeap[index / 2]) {
                    swap(minHeap, index, index / 2);
                    index = index / 2;
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void swap(long[] array, int index1, int index2) {
        long temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
