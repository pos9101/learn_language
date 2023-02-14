// CalculateString.cs

using System;
using System.Linq;

public class Solution {
    public int solution(string my_string) {
        int answer = 0;
        var strs = my_string.Split(" ");
        
        int temp = int.Parse(strs[0]);
        for(int i = 1; i + 1 < strs.Length; i+=2) {
            switch(strs[i]) {
                case "+":
                    temp += int.Parse(strs[i+1]);
                    break;
                case "-":
                    temp -= int.Parse(strs[i+1]);
                    break;
            }
        }
        answer = temp;
        return answer;
    }
}