// OXQuiz.cs

using System;

public class Solution {
    public string[] solution(string[] quiz) {
        string[] answer = new string[quiz.Length];
        int index = 0;
        foreach(var aQuiz in quiz) {
            var splitArray = aQuiz.Split(" ");
            int temp = 0;
            switch(splitArray[1]) {
                case "+":
                    temp = Convert.ToInt32(splitArray[0]) + Convert.ToInt32(splitArray[2]);
                    break;
                case "-":
                    temp = Convert.ToInt32(splitArray[0]) - Convert.ToInt32(splitArray[2]);
                    break;
                default :
                    
                    break;
            }
            if(Convert.ToInt32(splitArray[4]) == temp) {
                answer[index] = "O";
            } else {
                answer[index] = "X";
            }
            index++;
        }
        return answer;
    }
}