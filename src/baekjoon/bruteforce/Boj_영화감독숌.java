package baekjoon.bruteforce;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1436
 * bruteForce - 영화감독 숌(1436)
 *
 * 이번 문제에선, startWith 라는 함수를 사용해서 "666" 즉 6이 연속된 3개의 수를 검색하는 로직을 설계했습니다.
 */
public class Boj_영화감독숌 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int targetNumber = 0;
        int cnt = 0;
        while (true) {
            cnt++;
            if (searchNumber(cnt)) {
                targetNumber++;
            }
                
            if (targetNumber == N) {
                System.out.println(cnt);
                break;
            }
        }
    }

    private static boolean searchNumber(int cnt) {
        String sCnt = String.valueOf(cnt);

        if (sCnt.length() >= 3) {
            for (int i = 0; i <= sCnt.length() - 3; i++) {
                if (sCnt.startsWith("666", i)) {
                    return true;
                }
            }
        }
        return false;
    }
}
