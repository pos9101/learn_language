package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Baekjoon 2164
 * @link https://www.acmicpc.net/problem/2164
 */
public class CardTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> cards = new LinkedList<>();
        //Queue :   IN -> [first] ~ [last] -> OUT
        boolean isOdd = (N % 2 != 0) ? true : false;
        //must have removed odd number
        for (int i = 2; i <= N; i += 2) {
            cards.add(i);
        }

        if(N == 1) {
            cards.add(N);
        } else if(isOdd) {
            final int first = cards.getFirst();
            cards.removeFirst();
            cards.addLast(first);
        }

        int result = remainOne(cards);
        System.out.println(result);

        br.close();
    }

    /**
     * Processing
     * 0. if array.size == 1 -> return
     * 1. check odd/even
     * 2. remove array[odd]
     * 3. check in (1)   odd -> first to last
     *                   even -> nothing.
     *  repeat 1 ~ 3
     */
    public static int remainOne(LinkedList<Integer> cards) {
        int BEFORE_CARD_SIZE = cards.size();
        //return if array size is one
        if(BEFORE_CARD_SIZE == 1) {
            return cards.get(0);
        }

        final boolean isOdd = BEFORE_CARD_SIZE % 2 != 0 ? true : false;
        //remove odd numbers
        Iterator<Integer> iter = cards.iterator();
        int i = 0;
        while (iter.hasNext()) {
            Integer next = iter.next();
            if(i % 2 == 0) {
                iter.remove();
            }
            i++;
        }
        //odd action
        if(isOdd) {
            final int first = cards.getFirst();
            cards.removeFirst();
            cards.addLast(first);
        }

        return remainOne(cards);
    }
}
