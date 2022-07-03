package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_123더하기 {
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ordCnt = Integer.parseInt(br.readLine());

        while (ordCnt-- > 0) {
            int N = Integer.parseInt(br.readLine());
            dp = new int[N+1];
            for (int i = 0; i < dp.length; i++) {
                if (i < 3) dp[i] = i;
                else if (i == 3) dp[i] = 4;
                else {
                    dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
                }
            }
            System.out.println(dp[N]);
        }

    }
}
