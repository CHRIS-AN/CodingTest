package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_문자열반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String line = st.nextToken();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                for (int j = 0; j < R; j++) {
                    sb.append(line.charAt(i));
                }
            }
            System.out.println(sb);
        }
    }
}
