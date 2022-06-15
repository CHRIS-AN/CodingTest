package baekjoon.bruteforce;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2231
 * bruteForce - 분해합(2231)
 */
public class Boj_분해합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = 0;
        int N = sc.nextInt();
        int defaultR = N;

        for (int i = N; i >= 1; i--) {
            String sN = String.valueOf(i);
            int sum = 0;
            for (int j = 0; j < sN.length(); j++) {
                 sum += sN.charAt(j) - '0';
            }
            if (i + sum == defaultR) min = i;
        }
        System.out.println(min);
    }
}
