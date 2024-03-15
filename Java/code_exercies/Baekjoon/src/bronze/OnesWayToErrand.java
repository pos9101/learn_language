package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 5554
 * @link https://www.acmicpc.net/problem/5554
 */
public class OnesWayToErrand {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int homeToSchool = Integer.parseInt(br.readLine());
        int schoolToPcRoom = Integer.parseInt(br.readLine());
        int pcRoomToAcademy = Integer.parseInt(br.readLine());
        int academyToHome = Integer.parseInt(br.readLine());
        int time = homeToSchool + schoolToPcRoom + pcRoomToAcademy + academyToHome;
        System.out.println(time / 60);
        System.out.println(time % 60);

        br.close();
    }
}
