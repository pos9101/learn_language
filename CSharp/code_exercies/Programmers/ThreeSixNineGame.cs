// ThreeSixNineGame.cs 

using System;

public class Solution {
    public int solution(int order) {
        int answer = 0;
        do{
            switch(order % 10) {
            case 3:
            case 6:
            case 9:
                answer++;
                break;
            default:
                break;
            }
        } while((order /= 10) != 0);

        return answer;
    }
}