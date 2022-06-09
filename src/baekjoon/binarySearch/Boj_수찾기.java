package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다.
 *
 * 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
 *
 * 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
 *
 * 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다.
 *
 * 모든 정수의 범위는 -2의 31승 보다 크거나 같고 2의 31승 보다 작다. (int)
 */

public class Boj_수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] searchInRange = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) searchInRange[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(searchInRange);

        int M = Integer.parseInt(br.readLine());
        int[] keyArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) keyArr[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch2(keyArr[i], 0, searchInRange.length-1, searchInRange)).append('\n');
        }

        System.out.println(sb);
    }

    // 재귀적 탐색
    static int binarySearch(int key, int low, int high, int[] searchInRange) {
        int mid;
        if (low <= high) {
            mid = (low + high) / 2;
            if (key == searchInRange[mid]) return 1;
            else if (key < searchInRange[mid]) return binarySearch(key, low, mid - 1, searchInRange);
            else return binarySearch(key, mid + 1, high, searchInRange);
        }
        return 0;
    }

    // 반복적 탐색
    static int binarySearch2(int key, int low, int high, int[] searchInRange) {
        int mid;
        while(low <= high) {
            mid = (low + high) / 2;
            if(key == searchInRange[mid]) return 1;
            else if(key < searchInRange[mid]) high = mid - 1;
            else low = mid + 1;
        }

        return 0; 
    }
}
