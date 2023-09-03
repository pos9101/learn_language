package silver;

import java.io.*;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfTestcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < numOfTestcase; i++) {
            String line = br.readLine();
            bw.write(isVPS(line) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static String isVPS(String line) {
        Stack<Character> bracketStack = new Stack<>();
        int length = line.length();
        for (int j = 0; j < length; j++) {
            char c = line.charAt(j);
            if(c == '('){
                bracketStack.push(c);
            } else if (c == ')') {
                if(bracketStack.empty()) {
                    return "NO";
                }
                bracketStack.pop();
            }
        }
        if(!bracketStack.empty()) {
            return "NO";
        } else {
            return "YES";
        }
    }
}
