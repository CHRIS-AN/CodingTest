package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_16940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] adjList = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            adjList[x].add(y);
            adjList[y].add(x);
        }

        int inp[] = new int[N];
        int ord[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inp[i] = Integer.parseInt(st.nextToken()) - 1;
            ord[inp[i]] = i;
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(adjList[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (ord[o1] < ord[o2]) return -1;
                    else return 1;
                }
            });
        }

        boolean[] chk = new boolean[N];

        Queue<Integer> qu = new LinkedList<>();
        ArrayList<Integer> compareList = new ArrayList<>();

        qu.offer(0);
        chk[0] = true;

        while (!qu.isEmpty()) {
            int node = qu.poll();
            compareList.add(node);

            for (int adjNode : adjList[node]) {
                if (!chk[adjNode]) {
                    qu.offer(adjNode);
                    chk[adjNode] = true;
                }
            }
        }

        boolean isTrue = true;
        for (int i = 0; i < N; i++) {
            if (compareList.get(i) != inp[i]) {
                isTrue = false;
                break;
            }
        }

        if (isTrue) System.out.println(1);
        else System.out.println(0);
    }
}

