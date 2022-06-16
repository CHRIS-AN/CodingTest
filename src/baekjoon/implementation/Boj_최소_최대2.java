package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://github.com/tony9402/baekjoon/tree/main/implementation
 * 위 링크 추천 문제
 *
 * https://www.acmicpc.net/problem/20053
 * implementation - 최소, 최대2
 */
public class Boj_최소_최대2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<Integer> list;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list);
            sb.append(list.get(0)).append(' ').append(list.get(list.size() - 1)).append('\n');
        }

        System.out.println(sb);
    }
}
