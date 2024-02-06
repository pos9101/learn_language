package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * Baekjoon 2263
 * @link https://www.acmicpc.net/problem/2263
 */
public class CircuitOfTree {
    static StringJoiner sj;
    static int[] inOrder;
    static int[] postOrder;
    static Map<Integer, Integer> inOrderIdxMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sj = new StringJoiner(" ");
        final int N = Integer.parseInt(br.readLine());
        inOrder = new int[N];
        postOrder = new int[N];
        inOrderIdxMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            inOrderIdxMap.put(inOrder[i], i);
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        solvePreOrder(0, N - 1, 0, N - 1);
        System.out.println(sj.toString());
        br.close();
    }

    private static void solvePreOrder(int inOrderFirstIdx, int inOrderLastIdx,
                                      int postOrderFirstIdx, int postOrderLastIdx) {
        if(inOrderFirstIdx > inOrderLastIdx || postOrderFirstIdx > postOrderLastIdx) return;
        int root = postOrder[postOrderLastIdx];
        int rootIdxInOrder = inOrderIdxMap.get(root);
        sj.add(String.valueOf(root));

        /**
         *  ex Tree
         *          1
         *      2        3
         *   4    5    6    7
         *  8 9 10 11   12
         *
         *  inOrder   : 8 4 9 2  10 5 11 1  6 12 3 7
         *  postOrder : 8 9 4 10 11 5 2  12 6 7  3 1
         */

        //inOrder 왼쪽 개수
        int leftCnt = rootIdxInOrder - inOrderFirstIdx;
        //inORder 오른쪽 개수
        int rightCnt = inOrderLastIdx - rootIdxInOrder;

        //left
        solvePreOrder(inOrderFirstIdx, inOrderFirstIdx + leftCnt - 1, postOrderFirstIdx, postOrderFirstIdx + leftCnt - 1);
        //right
        solvePreOrder(inOrderLastIdx - rightCnt + 1, inOrderLastIdx, postOrderLastIdx - rightCnt, postOrderLastIdx - 1);
    }
}
