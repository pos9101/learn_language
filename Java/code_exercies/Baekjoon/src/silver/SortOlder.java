package silver;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Baekjoon 10814
 * @link https://www.acmicpc.net/problem/10814
 */
public class SortOlder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(br.readLine());
        LinkedList<Member> members = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Member newMember = new Member(Short.parseShort(st.nextToken()), st.nextToken());
            joinMember(members, newMember);
        }

        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            bw.write(member.getAge() + " " + member.getName() + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void joinMember(LinkedList<Member> members, Member newMember) {
        boolean inserted = false;
        final int index = searchBinary(members, newMember.getAge(), 0, members.size() -1);
        if(index >= members.size()) {
            members.addLast(newMember);
        } else {
            members.add(index, newMember);
        }
    }

    private static int searchBinary(LinkedList<Member> members, int value, int min, int max) {
        if(min > max) {
            return min;
        }
        int mid = (min + max) / 2;
        if (value >= members.get(mid).getAge()) {
            return searchBinary(members, value, mid + 1, max);
        } else {
            return searchBinary(members, value, min, mid - 1);
        }
    }

    static class Member {
        private final short age;
        private final String name;

        public Member(short age, String name) {
            this.age = age;
            this.name = name;
        }

        public Short getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
}
