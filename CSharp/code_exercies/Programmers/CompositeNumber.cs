//CompositeNumber.cs

using System;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        //4부터 n 까지 체크
        for(int i = 4; i <= n; i++) {
            //i 가 합성수인지 체크
            for(int j = i-1; j > 1; j--) {
                if(i % j == 0) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}