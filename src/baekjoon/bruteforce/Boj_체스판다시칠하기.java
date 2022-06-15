package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1018
 * bruteForce - 체스판 다시 칠하기 (1018)
 * 최악의 경우 (42 * 42) * (8*8) * (8*8) = 7,225,344 만큼
 */
public class Boj_체스판다시칠하기 {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");

        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                fillColor(i , j, 'B', 'W', board);
                fillColor(i , j, 'W', 'B', board);
            }
        }
        System.out.println(min);
    }

    private static void fillColor(int row, int col, char target, char diffTarget, char[][] board) {
        int cnt = 0;
        int leftUp = (row + col) % 2;

        for (int i = row; i < row + 8; i++) {
            for (int j = col; j < col + 8; j++) {
                if ((i + j) % 2 == leftUp) {
                    if (board[i][j] != target) cnt++;
                }else {
                    if (board[i][j] != diffTarget) cnt++;
                }
            }
        }

        min = Math.min(min, cnt);
    }
}
