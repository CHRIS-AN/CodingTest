package baekjoon.sorting;

import java.io.*;

/**
 * 수 정렬하기3 (10989)
 * https://www.acmicpc.net/problem/10989
 *
 * 메모리, 시간 복잡도를 잘 고려해서 코드 구현을 해야합니다.
 * 입력 되는 수의 범위는 1~10000 입니다.
 *
 * 이 문제는 두 가지 방법이 있습니다.
 * Collections.sort 시, 메모리 초과가 될 것입니다.
 * 그래서
 * 첫 번째로는 Arrays.sort 로 하면 힘겹게 통과가 됩니다
 * 하지만, 시간 복잡도 측면에서 두 번째보다 효율이 좋지 않습니다.
 * 두 번째 방법은 아래와 같이 Counting sort 입니다.
 * 이렇게 했을 시, 시간효율이 Arrays.sort 보다도 좋게 나옵니다.
 */
public class Boj_수정렬하기3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int count[] = new int[10001];

        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i+"\n");
            }
        }

        System.out.println(sb);
    }
}
