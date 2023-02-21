// CutAndSaveArray.cs

using System;

public class Solution {
    public string[] solution(string my_str, int n) {
        string[] answer = new string[100];
        int strLength = my_str.Length;
        int temp = 0;
        for(int i = 0; i < strLength; i+= n) {
            int last;
            if(i + n > strLength) {
                last = strLength - i;
            } else {
                last = n;
            }
            answer[temp] = my_str.Substring(i, last);
            temp++;
        }
        Array.Resize(ref answer, temp);
       
        return answer;
    }
}