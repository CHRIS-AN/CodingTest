package baekjoon.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1427
 * sorting - 소트인사이드(1427)
 *
 * 시간제한은 2초.
 * 메모리 제한이 128MB
 *
 * 이 문제는 메모리를 더 유념해야하는 문제인가 싶다.
 */
public class Boj_소트인사이드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        List<Integer> inputData = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            inputData.add(line.charAt(i) - '0');
        }
        Collections.sort(inputData, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i : inputData) {
            sb.append(i);
        }
        System.out.println(sb);
    }
}
