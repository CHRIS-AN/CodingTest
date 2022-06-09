package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_상수 {
    static int reverseNumber (String num) {
        int result = 0;
        for (int i = num.length() - 1; i >= 0; i--) result += (int)Math.pow(10, i) * (num.charAt(i) - '0');
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(Math.max(reverseNumber(st.nextToken()),reverseNumber(st.nextToken())));

    }
}
