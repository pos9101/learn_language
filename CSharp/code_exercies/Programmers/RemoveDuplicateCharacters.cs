// RemoveDuplicateCharacters.cs

using System;
using System.Linq;

public class Solution {
    public string solution(string my_string) {
        string answer = new String(my_string.Distinct().ToArray());
        
        return answer;
    }
}