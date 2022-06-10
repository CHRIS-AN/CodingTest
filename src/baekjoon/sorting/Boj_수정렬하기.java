package baekjoon.sorting;

import java.util.*;

/**
 * 수 정렬하기 (2750)
 * https://www.acmicpc.net/problem/2750
 *
 * 중복이 안돼? 그러면 HashSet 을 고려.
 * 하지만, HashSet 은 순서가 불규칙
 *
 * HashSet 을 정렬하는 방법은 2가지
 * 1. TreeSet 을 이용하는 방법
 * 2. HashSet -> List 로 변환한 뒤, Collections.sort 사용
 */
public class Boj_수정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < N; i++) hs.add(sc.nextInt());

        /* 1.
         TreeSet<Integer> sortSet = new TreeSet<>();
         sortSet.addAll(hs);
         */

        // 2
        List<Integer> sortSet = new ArrayList<>(hs);
        Collections.sort(sortSet);
        for (int i : sortSet) System.out.println(i);
    }
}