package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_아기상어2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        Fish shark = null;
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(temp[j]) == 9) {
                    shark = new Fish(i, j, 2, 0,0);
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int[] moveR = {-1, 1, 0, 0};
        int[] moveC = {0, 0, -1, 1};

        // 먹이를 찾는 과정에서 먹을 수 있는 먹이들의 위치를 저장하기 위한 우선순위큐
        // 내부 정렬 기준은 다음과 같다.
        // 1. 가장 거리가 가까운 먹이
        // 2. 거리가 같은 경우 위에 있는 먹이'
        // 3. 같은 행에 있으면 가장 왼쪽에 있는 먹이
        PriorityQueue<Fish> pq = new PriorityQueue<Fish>(new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                if (o1.distance == o2.distance) {
                    if (o1.row == o2.row) {
                        return o1.col - o2.col;
                    } else {
                        return o1.row - o2.row;
                    }
                } else {
                    return o1.distance - o2.distance;
                }
            }
        });

        Queue<Fish> queue = new LinkedList<>();
        queue.offer(shark);

        while(true) {
            boolean[][] chkMap = new boolean[N][N];

            chkMap[queue.peek().row][queue.peek().col] = true;

            while (!queue.isEmpty()) {
                Fish fish = queue.poll();
                int nowRow = fish.row;
                int nowCol = fish.col;

                for (int i = 0; i < 4; i++) {
                    int mr = nowRow + moveR[i];
                    int mc = nowCol + moveC[i];

                    if (mr < 0 || mr >= N || mc < 0 || mc >= N || map[mr][mc] > fish.size || chkMap[mr][mc]) continue;

                    if (map[mr][mc] < fish.size && map[mr][mc] != 0)
                        pq.offer(new Fish(mr, mc, fish.size, fish.eatCount + 1, fish.distance + 1));
                    else
                        queue.offer(new Fish(mr, mc, fish.size, fish.eatCount, fish.distance+1));

                    chkMap[mr][mc] = true;
                }
            }

            if (pq.isEmpty()) {
                System.out.println(result);
                return;
            }

            Fish fish = pq.poll();
            System.out.println(fish.row + " " +fish.col + " : " + fish.size);

            if (fish.size == fish.eatCount) {
                fish.size++;
                fish.eatCount = 0;
            }

            map[fish.row][fish.col] = 0;
            result += fish.distance;
            queue.offer(new Fish(fish.row, fish.col, fish.size, fish.eatCount, 0));
            pq.clear();
        }
    }

    // 맵내에 있는 물고기를 표현할 클래스
    static class Fish {
        int row;            // 행
        int col;            // 열    
        int size;           // 상어의 몸집
        int eatCount;       // 상어가 먹이 먹은 횟수
        int distance;       // 상어가 이동한 횟수

        public Fish(int row, int col, int size, int eatCount, int distance) {
            this.row = row;
            this.col = col;
            this.size = size;
            this.eatCount = eatCount;
            this.distance = distance;
        }
    }
}