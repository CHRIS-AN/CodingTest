package algorithm;

import java.util.Arrays;

public class 플로이드와샬 {
    static final int INF = 1_000_000_000;
    public static void main(String[] args) {
        int[][] inputData = {
                                 {1,2,1},
                                 {2,3,3},
                                 {5,2,2},
                                 {1,4,2},
                                 {5,3,1},
                                 {5,4,2},
                            };

        int n = 5;
        solution(n, inputData);
    }

    static void solution(int n, int[][] input) {
        //1. 2차원 배열 생성(기본조건)
        int[][] floyd = new int[n][n];

        //2.
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // 출발정점과 도착정점이 같을 땐 가중치가 0
                if(i == j) {
                    floyd[i][j] = 0;

                // 일단 비교하더라도 큰 수인 높은 수로 초기화를 시킴
                }else {
                    floyd[i][j] = INF;
                }
            }
        }

        //3. input 받은 값에서 각 정점의 가중치 잇기 (idx 맞추기 위해 '-1' 을 함)
        for (int i = 0; i < input.length; i++) {
            floyd[input[i][0] - 1][input[i][1] - 1] = input[i][2];
        }

        // 입력 출력
        System.out.println("=============입력=============");
        for (int[] row : floyd) System.out.println(Arrays.toString(row));

        // k : 거처가는 노드
        for (int k = 0; k < n; k++) {
            // i : 출발 노드
            for (int i = 0; i < n; i++) {
                if (i == k) continue; // 출발지와 경유지가 같다면 pass
                // j : 도착 노드
                for (int j = 0; j < n; j++) {
                    if (i == j || j == k) continue; // 출발지와 도착지가 같거나, 도착지가 경유지면 pass
                    // 비교 작업이 필요.
                    // i -> j  VS  i -> k(경유지) -> j
                    floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
                }
            }
        }

        // 결과 출력
        System.out.println("=============결과=============");
        for (int[] row : floyd) System.out.println(Arrays.toString(row));
    }
}
