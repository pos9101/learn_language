// throwsBall.cs
using System;

public class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int numberofPeople = numbers.Length;
        int i = 0;
        while(k > 1) {
            i+= 2;
            k--;
        }
        answer = numbers[i % numberofPeople];
        return answer;
    }
}