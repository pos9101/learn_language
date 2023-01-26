// UpperAndLower.cs

using System;

public class Solution {
    public string solution(string my_string) {
        string answer = "";
        foreach(char spell in my_string) {
            if(spell >= 'a') {
                answer += Char.ToUpper(spell);
            } else {
                answer += Char.ToLower(spell);
            }
        }
        return answer;
    }
}