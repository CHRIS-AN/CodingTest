package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_Z {
    static int number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int targetR = Integer.parseInt(st.nextToken());
        int targetC = Integer.parseInt(st.nextToken());

        N = (int)Math.pow(2, N);
        recursive(0, 0, N, targetR, targetC);
    }

    private static void recursive(int row, int col, int N, int tR, int tC) {
        // base case
        if (row == tR && col == tC) {
            System.out.println(number);
            return;
        }

        int nN;
        if (confirmBlock(row, col, tR, tC, N)) {
            nN = N / 2;
            recursive(row, col, nN, tR, tC); // 1사분면
            recursive(row, col + nN, nN, tR, tC); // 2사분면
            recursive(row  + nN, col, nN, tR, tC); // 3사분면
            recursive(row  + nN, col  + nN, nN, tR, tC); // 4사분면
        }
    }

    private static boolean confirmBlock(int row, int col, int tR, int tC, int N) {
        if (!(row <= tR && col <= tC && tR < N + row && tC < N + col)) number += N * N;
        else return true;
        return false;
    }
}
