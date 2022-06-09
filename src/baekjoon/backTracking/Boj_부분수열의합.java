package baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Boj_부분수열의합{
    static int N;
    static int[] inputData;
    static boolean[] visited = new boolean[2_000_000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        inputData = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) inputData[i] = Integer.parseInt(st.nextToken());

        sumSubsequence(0,0);

        int answer = 1;
        while(visited[answer]) answer++;
        System.out.println(answer);
    }

    static void sumSubsequence(int depth, int sum){
        if(depth > 0) {

            visited[sum] = true;
            return;
        }

        sumSubsequence(depth + 1,sum + inputData[depth]);
        sumSubsequence(depth + 1, sum);
    }
}