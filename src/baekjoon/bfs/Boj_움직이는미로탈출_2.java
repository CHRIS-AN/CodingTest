package baekjoon.bfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_움직이는미로탈출_2 {

    static int[] dx = {0, -1, 0, 1, 1, -1, 1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, -1, 1};

    static int solution(char[][] board) {
        int max = 8;
        boolean[][][] wall = init(board, max);
        Queue<Person> q = new LinkedList<>();
        q.offer(new Person(7, 0, 0)); //왼쪽 아래에서 출발

        while (!q.isEmpty()) {
            Person cur = q.poll();

            if (cur.time >= max || cur.x == 0 && cur.y == 7) return 1; //8초 이상이거나 오른쪽 위로 도착하면 가능한 것으로 판단
            if (wall[cur.x][cur.y][cur.time]) continue; //해당 시간에 벽이 존재하면 다른 방향은 확인하지 않는다.

            for (int i = 0; i < max; i++) { //상하좌우, 대각선 확인
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= max || ny >= max) continue; //범위 벗어나는지 확인하기
                if (wall[nx][ny][cur.time]) continue; //해당 시간에 벽이 존재하는 확인
                q.offer(new Person(nx, ny, cur.time + 1));
            }
            q.offer(new Person(cur.x, cur.y, cur.time + 1)); //시간을 늘리고, 움직이지 않는 경우 큐에 넣기
        }
        return 0;
    }

    static private boolean[][][] init(char[][] board, int max) {
        boolean[][][] result = new boolean[max][max][max];

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {

                if (board[i][j] == '#') { //맨 아래까지 벽을 이동하여 시간을 체크한다.
                    int time = 0;
                    for (int k = i; k < max; k++) {
                        result[k][j][time++] = true;
                    }
                }
            }
        }
        return result;
    }

    static class Person {
        int x, y, time; //x,y 좌표와 현재 시간

        public Person(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) board[i] = br.readLine().toCharArray();
        System.out.println(solution(board));
    }
}