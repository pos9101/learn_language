// FindNumber.cs

using System;

public class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        string strNum = num.ToString();
        var chars = strNum.ToCharArray();
        for(int i =1; i <= chars.Length; i++) {
            if(char.GetNumericValue(chars[i-1]) == k) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}