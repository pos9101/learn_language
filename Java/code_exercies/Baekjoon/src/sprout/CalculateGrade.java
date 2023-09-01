package sprout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 2754
 * @link https://www.acmicpc.net/problem/2754
 */
public class CalculateGrade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String grade = br.readLine();
        char main = grade.charAt(0);
        char sub = 0; // not '0'
        if(grade.length() > 1) {
            sub = grade.charAt(1);
        }
        System.out.println(calGrade(main, sub));

        br.close();
    }

    public static float calGrade(char main, char sub) throws IOException {
        float gradeRecord = 0.0f;
        switch(main) {
            case 'A':
                gradeRecord = 4.0f;
                break;
            case 'B':
                gradeRecord = 3.0f;
                break;
            case 'C':
                gradeRecord = 2.0f;
                break;
            case 'D':
                gradeRecord = 1.0f;
                break;
            case 'F':
                return gradeRecord;
            default:
                throw new IOException();
        }
        switch(sub) {
            case '+':
                return gradeRecord + 0.3f;
            case '0':
                return gradeRecord;
            case '-':
                return gradeRecord - 0.3f;
            default:
                throw new IOException();
        }
    }
}
