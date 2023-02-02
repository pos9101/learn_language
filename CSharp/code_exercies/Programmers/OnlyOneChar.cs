// OnlyOneChar.cs

using System;
using System.Linq;

public class Solution {
    public string solution(string s) {
        string answer = "";
        for(int i = 0; i < s.Length; i++) {
            bool hasChar = false;
            for(int j = 0; j < s.Length; j++ ){
                if(i == j)
                    continue;
                if(s[i] == s[j]) {
                    hasChar = true;
                    break;
                }
            }
            if(!hasChar) {
                answer += s[i];
            }
        }
        return string.Concat(answer.OrderBy(x=>x).ToArray());
    }
}