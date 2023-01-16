// CloseNumber.cs

using System;
using System.Linq;

public class Solution {
    public int solution(int[] array, int n) {
        var values = array.OrderBy(x => Math.Abs(n - x)).Take(2);
        int first = values.First();
        int second = values.Last();
        
        if(first < second) {
            return first;
        } else {
            if(Math.Abs(n - first) == Math.Abs(n - second)) {
                return second;
            } else {
                return first;
            }
        }
    }
}