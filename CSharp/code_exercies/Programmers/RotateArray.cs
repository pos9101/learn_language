//RotateArray.cs

using System;

public class Solution {
    public int[] solution(int[] numbers, string direction) {
        int arraySize = numbers.Length;
        int startNum;
        int[] answer = new int[arraySize];
        int temp;
        switch(direction) {
            case "left":
                startNum = 1;
                break;
            case "right":
            default:
                startNum = arraySize -1;
                break;
        }
        int i = 0;
        while(i < arraySize) {
            answer[i] = numbers[(startNum + i) % arraySize];
            i++;
        }
        return answer;
    }
}