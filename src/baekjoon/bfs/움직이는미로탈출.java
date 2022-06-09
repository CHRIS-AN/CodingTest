package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 움직이는미로탈출 {
    static char[][] board = new char[8][8];
    static boolean[][][] visited = new boolean[9][8][8];
    static final int direction = 9;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1, 0}; // 시계방향
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1, 0};
    static boolean flag;

    static class CharacterLoc {
        int x;
        int y;
        int mapMovedCnt;

        public CharacterLoc(int x, int y, int mapMovedCnt) {
            this.x = x;
            this.y = y;
            this.mapMovedCnt = mapMovedCnt;
        }
    }
    static int bfs(char[][] initBoard) {
        Queue<CharacterLoc> qu = new LinkedList<>();
        qu.offer(new CharacterLoc(7, 0, 0));

        while (!qu.isEmpty()) {
            CharacterLoc point = qu.poll();
            if (point.x == 0 && point.y == 7) return 1;

            for (int i = 0; i < direction; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (!isPossible(nx, ny)) continue;
                if (board[nx][ny] == '#') continue;

             //   qu.offer(new CharacterLoc(nx, ny));
            }
        }
        return 0;
    }

    private static char[][] remapBoard(int x, int y, char[][] board) {
        char[][] newBoard = new char[8][8];
         for (int i = 7; i >= 1; i--) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == '#') board[i][j] = '.';
                if (board[i-1][j] == '#') {
                    newBoard[i][j] = '#';
                }else newBoard[i][j] = '.';
            }
        }

        for (int i = 0; i < 8; i++) {
            newBoard[0][i] = '.';
        }
        return newBoard;
    }

    static boolean isPossible(int x, int y) {
        return x >= 0 && y >= 0 && x < 8 && y < 8;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) board[i] = br.readLine().toCharArray();
        System.out.println(bfs(board));
    }
}
