// IHateEnglish.cs

using System;

public class Solution {
    public long solution(string numbers) {
        String temp = numbers;
        temp = temp.Replace("zero", "0");
        temp = temp.Replace("one", "1");
        temp = temp.Replace("two", "2");
        temp = temp.Replace("three", "3");
        temp = temp.Replace("four", "4");
        temp = temp.Replace("five", "5");
        temp = temp.Replace("six", "6");
        temp = temp.Replace("seven", "7");
        temp = temp.Replace("eight", "8");
        temp = temp.Replace("nine", "9");
        return Convert.ToInt64(temp);
    }
}