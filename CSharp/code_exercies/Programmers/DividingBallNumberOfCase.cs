// dividingBallNumberOfCase.cs

using System;

public class Solution {
    public int solution(int balls, int share) {
        double answer = 1; //int, long 다 범위 초과하고 BigInteger는 제한사항이라 못쓰게 되어있음.
        if(balls == share) {
            return (int)answer;
        }
        int a = balls - share;
        int b = share;
        if(a > b) {
            for(int i = balls; i > a; i--) {
                answer *= i;
            }
            for(int i = b; i > 0; i--) {
                answer /= i;
            }
        } else {
            for(int i = balls; i > b; i--) {
                answer *= i;
            }
            for(int i = a; i > 0; i--) {
                answer /= i;
            }
        }
        
        return (int)answer;
    }
}