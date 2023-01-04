// 2DArray.cs
using System;

public class Solution {
    public int[,] solution(int[] num_list, int n) {
        int rowNum = num_list.Length/n;
        int colNum = n;
        int[,] answer = new int[rowNum, colNum];
        int numIdx = 0;
        for(int i=0; i<rowNum; i++) {
            for(int j=0; j<colNum; j++) {
                answer[i, j] = num_list[numIdx++];
            }
        }
        return answer;
    }
}