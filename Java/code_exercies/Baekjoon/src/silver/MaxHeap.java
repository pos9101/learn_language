package silver;

import java.io.*;

/**
 * Baekjoon 11279
 * @link https://www.acmicpc.net/problem/11279
 */
public class MaxHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int N = Integer.parseInt(br.readLine());
        //not use maxHeap[0]
        long[] maxHeap = new long[100001];
        int sizeOfHeap = 0;
        for (int i = 0; i < N; i++) {
            long val = Long.parseLong(br.readLine());
            if(val == 0) {
                bw.write(maxHeap[1] + "\n");
                maxHeap[1] = maxHeap[sizeOfHeap];
                if(sizeOfHeap != 0) {
                    maxHeap[sizeOfHeap] = 0;
                    --sizeOfHeap;
                }
                int index = 1;
                while(index * 2 <= 100000 && maxHeap[index * 2] != 0) {
                    int maxChildIndex = index * 2;
                    if(maxHeap[index * 2 + 1] != 0 && maxHeap[index * 2 + 1] > maxHeap[maxChildIndex]) {
                        maxChildIndex = index * 2 + 1;
                    }
                    if(maxHeap[maxChildIndex] > maxHeap[index]) {
                        swap(maxHeap, maxChildIndex, index);
                        index = maxChildIndex;
                    } else {
                        break;
                    }
                }
            } else {
                int index = ++sizeOfHeap;
                maxHeap[index] = val;
                while (index / 2 >= 1 && maxHeap[index] > maxHeap[index / 2]) {
                    swap(maxHeap, index, index / 2);
                    index = index / 2;
                }
            }
        }
        bw.flush();
        br.close();
        br.close();
    }

    public static void swap(long[] array, int index1, int index2) {
        long temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
