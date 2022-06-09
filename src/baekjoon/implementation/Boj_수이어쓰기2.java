package baekjoon.implementation;

import java.util.*;

public class Boj_수이어쓰기2 {
    static int N,K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        long target = 0;	// 찾을 숫자가 포함된 슷지
        long numLen = 1;	// 계속해서 올릴 자릿수
        long numCnt = 9;	// 9,90,900~

        while(K > numCnt*numLen) {
            K -= (numLen*numCnt);
            target += numCnt;

            numLen++;
            numCnt *=10;
        }

        target = (target+1) + (K - 1) / numLen;

        if(target > N) System.out.println(-1);
        else {
            int idx = (int)((K - 1) % numLen);
            System.out.println(String.valueOf(target).charAt(idx));
        }
    }
}