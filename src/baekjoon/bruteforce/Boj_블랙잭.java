package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2798
 * bruteForce - 블랙잭(2798)
 */
public class Boj_블랙잭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] inputData = new int[N];
        for (int i = 0; i < N; i++) {
            inputData[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int temp = inputData[i] + inputData[j] + inputData[k];
                    if (temp > M) continue;
                    max = Math.max(max, temp);
                }
            }
        }
        System.out.println(max);
    }
}
