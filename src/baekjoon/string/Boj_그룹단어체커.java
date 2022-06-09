package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Boj_그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] inputArr = new String[N];
        for (int i = 0; i < N; i++) inputArr[i] = br.readLine();
        int sum = 0;
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < inputArr.length; i++) {
            char pre = ' ';
            boolean flag = false;
            for (int j = 0; j < inputArr[i].length(); j++) {
                if (pre == inputArr[i].charAt(j)) continue;
                pre = inputArr[i].charAt(j);
                if (!hs.contains(pre)) hs.add(pre);
                else {
                    flag = true;
                    break;
                }
            }
            if (!flag) sum++;
            hs.clear();
        }
        System.out.println(sum);
    }
}
