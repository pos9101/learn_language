// PrimeFactor.cs

using System;

public class Solution {
    public int[] solution(int n) {
        int[] answer = new int[13];
        int i = 2;
        int calValue = n;
        int arraySize = 0;
        //다 나눴을 때 종료
        while(calValue != 1) {
            bool isDoingWhile = false;
            //현재 나누는 값으로 나눠질때 까지 나눔
            while(calValue % i == 0) {
                isDoingWhile = true;
                calValue /= i;
            }
            if(isDoingWhile) {
                answer[arraySize++] = i;
            }
            i++;
        }
        Array.Resize(ref answer, arraySize);
        return answer;
    }
}