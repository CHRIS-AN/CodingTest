package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/11651
 * 좌표 정렬하기2 (11651)
 * 1탄이랑 비슷한 문제였습니다. 이번 문제는 Arrays.sort 로 정렬을 했습니다.
 */
public class Boj_좌표정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] inputData = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            inputData[i][0] = Integer.parseInt(line[0]);
            inputData[i][1] = Integer.parseInt(line[1]);
        }

        Arrays.sort(inputData, (e1, e2) -> {
			if(e1[1] == e2[1]) return e1[0] - e2[0];
            else return e1[1] - e2[1];
		});

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(inputData[i][0]).append(' ').append(inputData[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}
