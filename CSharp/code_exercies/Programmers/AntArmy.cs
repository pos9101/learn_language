using System;

public class Solution {
    public int solution(int hp) {
        int answer = 0;
        int gerneralNum = hp / 5;
        int temp = hp % 5;
        int knightNum = temp / 3;
        int workerNum = temp % 3;
        answer = gerneralNum + knightNum + workerNum;
        
        return answer;
    }
}