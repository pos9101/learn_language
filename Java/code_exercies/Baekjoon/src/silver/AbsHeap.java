package silver;

import java.io.*;

/**
 * Baekjoon 11286
 * @link https://www.acmicpc.net/problem/11286
 */
public class AbsHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int N = Integer.parseInt(br.readLine());
        int[] array = new int[N + 1];
        int size = 0;
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            if(val == 0) {
                bw.write(array[1] + "\n");
                if (size > 0) {
                    array[1] = array[size];
                    array[size] = 0;
                    --size;
                    moveTopDown(array, size);
                }
            } else {
                ++size;
                array[size] = val;
                moveBottomUp(array, size);
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void moveTopDown(int[] array, int size) {
        int index = 1;
        while(index * 2 <= size) {
            int absIdx = Math.abs(array[index]);
            int leftChildIdx = index * 2;
            int rightChildIdx = index * 2 + 1;
            int minChildIdx = leftChildIdx;
            int absMinChild = Math.abs(array[minChildIdx]);
            if(rightChildIdx <= size) {
                int absRightChild = Math.abs(array[rightChildIdx]);
                if(absRightChild < absMinChild ||
                        (absRightChild == absMinChild && array[rightChildIdx] < array[leftChildIdx])) {
                    minChildIdx = rightChildIdx;
                    absMinChild = absRightChild;
                }
            }
            if(absMinChild < absIdx) {
                swap(array, index, minChildIdx);
            } else if(absMinChild == absIdx && array[minChildIdx] < array[index]) {
                swap(array, index, minChildIdx);
            } else {
                break;
            }
            index = minChildIdx;
        }
    }

    private static void moveBottomUp(int[] array, int size) {
        int index = size;
        while(index > 1) {
            int parentIdx = index / 2;
            int absIdx = Math.abs(array[index]);
            int absParent = Math.abs(array[parentIdx]);
            if(absIdx < absParent) {
                swap(array, index, parentIdx);
            } else if(absIdx == absParent && array[index] < array[parentIdx]) {
                swap(array, index, parentIdx);
            } else {
                break;
            }
            index = parentIdx;
        }
    }

    private static void swap(int[] array, int index, int parentIdx) {
        int temp = array[index];
        array[index] = array[parentIdx];
        array[parentIdx] = temp;
    }
}
