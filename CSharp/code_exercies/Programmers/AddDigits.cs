// AddDigits.cs

using System;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        var chars = n.ToString().ToCharArray();
        foreach(var aChar in chars) {
            answer += (int)char.GetNumericValue(aChar);
        }
        return answer;
    }
}