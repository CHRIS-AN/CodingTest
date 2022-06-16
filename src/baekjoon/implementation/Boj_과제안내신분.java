package baekjoon.implementation;

import java.util.Scanner;

public class Boj_과제안내신분 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] visited = new boolean[31];
        visited[0] = true;
        for (int i = 0; i < 28; i++) {
            visited[sc.nextInt()] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 30; i++) {
            if (!visited[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}
