package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

* 주의할 점 *
    1. 시작 정점은 1이기 때문에 1이 아닌 다른 정점부터 시작하는 방문 순서는 올바르지 않습니다.
    2. 간선은 양방향으로 저장
    3. 같은 레벨에 있는 정점들의 순서만 중요합니다. 즉, 한 정점에서 이동하는 정점들과 다른 정점에서 이동하는 정점들의 순서가 섞이면 안 됩니다
*/
public class Boj_BFS스페셜저지 {
    static int N; 
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    static int[] inputArr;
    static Queue<Integer> qu = new LinkedList<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        inputArr = new int[N + 1];


        for(int i = 0; i < N + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }

        // input 데이터 저장
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        isPossibleBfs(1);
    }

    public static void isPossibleBfs(int x) {
        // 시작이 1이 아니면 0으로 아웃
        if(inputArr[1] != 1) {
            System.out.println(0);
            return;
        }

        qu.offer(x);
        visited[x] = true;

        int index = 2;
        while(!qu.isEmpty()) {
            int cur = qu.poll();

            // 현재 노드의 자식들 방문 처리
            int count = 0;
            for(int next : adjList.get(cur)) {
                if(!visited[next]) {
                    visited[next] = true;
                    count++;
                }
            }

            for(int i = index; i < (index + count); i++) {
                // 정답이 현재 노드의 자식이 아니라면 X
                if(!visited[inputArr[i]]) {
                    System.out.println(0);
                    return;
                } else qu.offer(inputArr[i]); // 정답이 현재 노드의 자식이면 큐에 순서대로 삽입
            }
            index += count;
        }

        System.out.println(1);
    }
}