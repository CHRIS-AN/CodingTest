package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/18870
 * sorting - Coordinate Compression (좌표 압축)
 */
public class Boj_좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int n : sorted) {
            if (!map.containsKey(n)) {
                map.put(n, idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            sb.append(map.get(n)).append(" ");
        }

        System.out.println(sb);
    }
}


/*
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> sortedList = new ArrayList<>();
        List<Integer> originList = new ArrayList<>();
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            sortedList.add(num);
            originList.add(num);
        }
        Collections.sort(sortedList);
        int rank = 0;
        for (int i : sortedList) {
            if (!hs.containsKey(i)) {
                hs.put(i, rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int key : originList) {
            sb.append(hs.get(key)).append(' ');
        }
        System.out.println(sb);
    }
* */