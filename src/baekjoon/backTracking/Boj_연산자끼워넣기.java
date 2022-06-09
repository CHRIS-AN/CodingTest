package baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_연산자끼워넣기 {
    static boolean[] visited = new boolean[10];
    static int[] numbers = new int[11];
    static int[] operators = new int[10];
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static StringTokenizer st;

    public static void dfs(int nIdx, int cum, int depth) {
        if (depth == N - 1) {
            if (cum > max) max = cum;
            if (cum < min) min = cum;
            return;
        }

        int sum = 0;
        for (int i = 0; i < N - 1; i++) { // 연산자에 맞게 루프
            if (!visited[i]) { // 연산자 dfs 방문처리
                switch (operators[i]) {
                    case 0:
                        sum = cum + numbers[nIdx];
                        break;
                    case 1:
                        sum = cum - numbers[nIdx];
                        break;
                    case 2:
                        sum = cum * numbers[nIdx];
                        break;
                    case 3:
                        sum = cum / numbers[nIdx];
                        break;
                }
                visited[i] = true;
                dfs( nIdx + 1, sum, depth + 1); // vIdx : 연산자 배열 인덱스
                                                              // nIdx : 피연산자 배열 인덱스
                visited[i] = false;
            }
        }
        // 백트래킹

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        // 숫자들을 저장해 놓습니다 'numbers 배열'
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int idx = 0;
        // 4가지 연산 타입을 루프를 돌아서,
        for (int i = 0; i < 4; i++) { // i가 0 = +, 1 = -, 2 = *, 3 = /
            int operator = Integer.parseInt(st.nextToken());
            // 각 연산자에 사용 횟수만큼 순차적으로 op 배열에 저장합니다. (최대 10)
            for (int j = 0; j < operator; j++) operators[idx++] = i;
        }

        dfs(1, numbers[0], 0);

        System.out.println(max);
        System.out.println(min);
    }
}
