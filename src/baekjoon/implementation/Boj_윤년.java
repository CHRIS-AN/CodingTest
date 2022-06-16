package baekjoon.implementation;


import java.util.Scanner;

/**
 * https://github.com/tony9402/baekjoon/tree/main/implementation
 * 위 링크 추천 문제입니다.
 *
 * https://www.acmicpc.net/problem/2753
 * implementation - 윤년(2753)
 */
public class Boj_윤년 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if (N % 4 == 0 && (N % 100 != 0 || N % 400 == 0)) System.out.println(1);
        else System.out.println(0);
    }
}
