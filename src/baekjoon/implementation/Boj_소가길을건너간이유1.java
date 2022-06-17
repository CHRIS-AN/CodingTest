package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14467
 * implementation - 소가 길을 건너간 이유1
 *
 * 어떤 자료구조를 사용 해야할까?
 * 그냥 아예 구현으로 밀어붙이는 문제인가?
 *
 * 이차원 배열로..? new int[N][2] 로 각 0, 1 개수를 cnt?
 * 그럼 또 안됨.
 *
 * boolean 으로 구현?
 *
 */
public class Boj_소가길을건너간이유1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());
            if (hs.containsKey(cow)) {
                if (hs.get(cow) != loc) cnt++;
            }
            hs.put(cow, loc);
        }
        System.out.println(cnt);
    }
}
