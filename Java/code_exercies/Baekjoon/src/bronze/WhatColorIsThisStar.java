package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 30676
 * @link https://www.acmicpc.net/problem/30676
 */
public class WhatColorIsThisStar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int lambda = Integer.parseInt(br.readLine());
        System.out.println(printColor(lambda));
        br.close();
    }

    private static String printColor(int lambda) {
        if(lambda >= 620) return "Red";
        if(lambda >= 590) return "Orange";
        if(lambda >= 570) return "Yellow";
        if(lambda >= 495) return "Green";
        if(lambda >= 450) return "Blue";
        if(lambda >= 425) return "Indigo";
        return "Violet";
    }
}
