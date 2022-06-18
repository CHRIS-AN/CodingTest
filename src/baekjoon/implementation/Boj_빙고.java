package baekjoon.implementation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2578
 * implementation - 빙고
 *
 */
public class Boj_빙고 {
    static final int bingoN = 5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[bingoN][bingoN];


        for (int i = 0; i < bingoN; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < bingoN; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<LinkedList<Integer>> bingoCase = new ArrayList<>();
        for (int i = 0; i < 12; i++) bingoCase.add(new LinkedList<>());
        int idx = 0;
        for (int i = 0; i < bingoN; i++) {
            for (int j = 0; j < bingoN; j++) {
                bingoCase.get(idx).add(board[i][j]);
            }
            idx++;
        }
        for (int i = 0; i < bingoN; i++) {
            for (int j = 0; j < bingoN; j++) {
                bingoCase.get(idx).add(board[j][i]);
            }
            idx++;
        }

        for (int i = 0; i < bingoN; i++) {
            for (int j = 0; j < bingoN; j++) {
                if (i == j) {
                    bingoCase.get(idx).add(board[i][j]);
                }
                if (i + j == 4) {
                    bingoCase.get(idx + 1).add(board[i][j]);
                }
            }
        }
        int[][] askedNumber = new int[bingoN][bingoN];
        for (int i = 0; i < bingoN; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < bingoN; j++) {
                askedNumber[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        boolean flag = false;
        int result = 0;
        for (int i = 0; i < bingoN; i++) {
            for (int j = 0; j < bingoN; j++) {
                cnt = 0;
                int priceAsked = askedNumber[i][j];
                for (List l : bingoCase) {
                    l.remove((Integer)priceAsked);
                    if (l.isEmpty()) {
                        cnt++;
                    }
                }

                if (cnt >= 3) {
                    flag = true;
                    result = i * 5 + (j + 1);
                    System.out.println(result);
                    break;
                }
            }
            if (flag) break;
        }
    }
}
