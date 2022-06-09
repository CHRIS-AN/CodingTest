package programmers.Lv2;

import java.util.ArrayList;
import java.util.List;

public class Pro_빛 {

     static int[] dirX = {0, 0, -1, 1};
     static int[] dirY = {1, -1, 0, 0};
     static boolean[][][] visited;

     static int cnt = 0;
     static List<Integer> answer = new ArrayList<>();

    static public int[] solution(String[] grid) {
        int[] answer = {};
        int row = grid.length;
        int col = grid[0].length();
        visited = new boolean[row][col][4];


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < 4; k++) {

                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] ss = {"SL","LR"};
         solution(ss);
    }
}
