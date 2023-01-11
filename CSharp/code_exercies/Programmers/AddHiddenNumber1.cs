//AddHiddenNumber1.cs

using System;

public class Solution {
    public int solution(string my_string) {
        int answer = 0;
        foreach(char spell in my_string) {
            switch(spell) {
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    answer += (int)Char.GetNumericValue(spell);
                    break;
                default:
                    break;
            }
        }
        return answer;
    }
}