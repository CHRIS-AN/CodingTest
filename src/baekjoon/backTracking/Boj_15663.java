package baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 순서가 있어야하고 중복이 발생하면 안된다 => SortedSet
// N과 M(9)
public class Boj_15663 {
    static int N, M;
    static int[] inputDataArr;
    static boolean[] visited;
    static int[] arr;
    static LinkedHashSet<String> hs = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {
        // base case
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            hs.add("" + sb);
            sb.setLength(0);
            return;
        }
        // recur
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = inputDataArr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        inputDataArr = new int[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputDataArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputDataArr);

        dfs(0);

        for (String value : hs) {
            System.out.println(value);
        }
    }
}