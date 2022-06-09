package baekjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_단어공부 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().toUpperCase();
        int[] alpha = new int[26];
        for (int i = 0; i < line.length(); i++) {
            int idx = line.charAt(i) - 65;
            alpha[idx]++;
        }
        int max = Integer.MIN_VALUE;

        for (int i : alpha) {
            max = Math.max(max, i);
        }
        int cnt = 0;
        int idx = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (max == alpha[i]) {
                cnt++;
                idx = i;
            }
        }

        if (cnt > 1) System.out.println("?");
        else System.out.println((char)(idx + 65));
    }
}
