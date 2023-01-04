//Morse1.cs

using System;

public class Solution {
    public string solution(string letter) {
        
        string[] morses = letter.Split(" ");
        return DecodeMorseCode(morses);
    }
    
    public string DecodeMorseCode(string[] morses) {
        string decodeValue = "";
        string[] morseTable = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        foreach(string aMorse in morses) {
            for(int i = 0; i < morseTable.Length; i++) {
                if(morseTable[i].Equals(aMorse)) {
                    decodeValue += (char)('a' + i);
                    break;
                }
            }
        }
        return decodeValue;
    }
}