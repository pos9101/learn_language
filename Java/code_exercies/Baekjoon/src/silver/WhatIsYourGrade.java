package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 25206
 * @link https://www.acmicpc.net/problem/25206
 */
public class WhatIsYourGrade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        float total = 0.0f;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String subject = st.nextToken();
            float credit = Float.parseFloat(st.nextToken());
            String grade = st.nextToken();
            float gradeNum;
            switch(grade) {
                case "A+":
                    gradeNum = 4.5f;
                    count += credit;
                    break;
                case "A0":
                    gradeNum = 4.0f;
                    count += credit;
                    break;
                case "B+":
                    gradeNum = 3.5f;
                    count += credit;
                    break;
                case "B0":
                    gradeNum = 3.0f;
                    count += credit;
                    break;
                case "C+":
                    gradeNum = 2.5f;
                    count += credit;
                    break;
                case "C0":
                    gradeNum = 2.0f;
                    count += credit;
                    break;
                case "D+":
                    gradeNum = 1.5f;
                    count += credit;
                    break;
                case "D0":
                    gradeNum = 1.0f;
                    count += credit;
                    break;
                case "F":
                    gradeNum = 0.0f;
                    count += credit;
                    break;
                case "P":
                default:
                    gradeNum = 0.0f;
                    break;
            }
            total += gradeNum * credit;
        }
        System.out.println(total / count);
        br.close();
    }
}
