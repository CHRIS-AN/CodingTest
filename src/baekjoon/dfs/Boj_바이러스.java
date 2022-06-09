package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_바이러스 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerCnt = convertStrToInt(br.readLine());
        int M = convertStrToInt(br.readLine());

        for (int i = 0; i <= M; i++) graph.add(i, new ArrayList<>());
        visited = new boolean[computerCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int a = convertStrToInt(st.nextToken());
            int b = convertStrToInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }


    }

    private static int convertStrToInt(String input) {
        return Integer.parseInt(input);
    }
}
