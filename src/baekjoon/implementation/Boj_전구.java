package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_전구 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[] light = new char[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            light[i] = st.nextToken().charAt(0);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());
            String temp = st.nextToken();
            int c =  Integer.parseInt(temp);
            switch (a) {
                // 1번 명령어
                case 1 :
                    light[b - 1] = temp.charAt(0);
                    break;

                // 2번 명령어
                case 2 :
                    for (int j = b-1; j < c; j++) {
                        if (light[j] == '0') {
                            light[j] = '1';
                        }
                        else light[j] = '0';
                    }
                    break;

                // 3번 명령어
                case 3 :
                    for (int j = b-1; j < c; j++) {
                        light[j] = '0';
                    }
                    break;
                // 4번 명령어
                case 4 :
                    for (int j = b-1; j < c; j++) {
                        light[j] = '1';
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : light) sb.append(c).append(' ');

        System.out.println(sb);
    }
}
