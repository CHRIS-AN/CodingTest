package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_트리의순회 {
    static int[] inorder, inIdx, postorder;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // n 개의 정점
        int n = Integer.parseInt(br.readLine());

        inorder = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            inorder[i] = Integer.parseInt(st.nextToken());

        postorder = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            postorder[i] = Integer.parseInt(st.nextToken());

        // inorder 인덱스
        inIdx = new int[n + 1];
        for (int i = 1; i <= n; i++)
            inIdx[inorder[i]] = i;
         /*
         8 4 9 2 10 5 1 6 3 7
         (idx = 8) : 1
         (idx = 4) : 2
         (idx = 9) : 3
         (idx = 2) : 4
         (idx = 10) : 5
         (idx = 5) : 6
         (idx = 1) : 7
         (idx = 6) : 8
         (idx = 3) : 9
         (idx = 7) : 10
          */


        solve(1, n, 1, n);
        System.out.println(sb.toString());
    }

    static void solve(int inorderStart, int inorderEnd, int postStart, int postEnd) {

        // 탈출 조건 (idx 위치가 start 가 end 보다 클 경우)
        if (inorderEnd < inorderStart || postEnd < postStart) {
            return;
        }

        int root = postorder[postEnd];
        int rIdx = inIdx[root];
        sb.append(root + " ");


        // 분할 정복
        int len = rIdx - inorderStart; // left 트리 길이
        solve(inorderStart, rIdx - 1, postStart, postStart + len - 1); // left 트리
        solve(rIdx + 1, inorderEnd, postStart + len, postEnd - 1); // right 트리
    }
}