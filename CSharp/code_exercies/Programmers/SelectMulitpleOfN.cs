// SelectMulitpleOfN.cs

using System;
using System.Linq;

public class Solution {
    public int[] solution(int n, int[] numlist) {
        return numlist.ToList().Where(x => x%n == 0).ToList().ToArray();
    }
}