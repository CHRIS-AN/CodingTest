package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1181
 * sorting - 단어정렬(1181)
 */
public class Boj_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> hs = new HashSet<>(N);
        for (int i = 0; i < N; i++) hs.add(br.readLine());

        List<String> list = new ArrayList<>(hs);

        Collections.sort(list, new Comparator<String>() {

           @Override
           public int compare (String o1, String o2) {
               if (o1.length() == o2.length()) return o1.compareTo(o2);
               else return o1.length() - o2.length();
           }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }
}
