//DiceNumber.cs

using System;

public class Solution {
    public int solution(int[] box, int n) {
        int answer = 0;
        int width = box[0];
        int height = box[1];
        int depth = box[2];
        
        answer = (width / n) * (height / n) * (depth / n);
        
        return answer;
    }
}