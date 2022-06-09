package baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_15665_ver2 {

    static int N,M;
    static int[] arr;
    static int[] inputDataArr;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth) {
        // base case
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        // recur

        Set<Integer> hs= new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (!hs.contains(inputDataArr[i])) {
                arr[depth] = inputDataArr[i];;
                hs.add(inputDataArr[i]);
                dfs(depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        arr = new int[M];
        inputDataArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputDataArr[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(inputDataArr);

        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (!hs.contains(inputDataArr[i])) {
                arr[0] = inputDataArr[i];
                hs.add(inputDataArr[i]);
                dfs(1);
            }
        }

        System.out.println(sb);
    }
}
