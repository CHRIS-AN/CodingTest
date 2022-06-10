package baekjoon.sorting;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  통계학 (2108)
 *  https://www.acmicpc.net/problem/2108
 *
 *  총 4개의 값을 출력 해야하는 문제.
 *  차근차근 하나씩 해결해나가면 될 문제였습니다.
 *
 *  Scanner -> BufferedReader 사용 시, 메모리 1/3 막, 시간복잡도 1/2 토막
 */
public class Boj_통계학 {
    static int[] result = new int[4];
    //static final int value = 4000;
    //static int[] mode = new int[value * 2 + 1]; // 최빈값

    static void calculateAverage (int sum, int N) {
        result[0] = (int)Math.round((double) sum / N);
    }
    static void searchMedianValue(List<Integer> inputData, int N) {
        Collections.sort(inputData);
        result[1] = inputData.get(N / 2);
        result[3] = inputData.get(inputData.size() -1) - inputData.get(0);
    }
    static void searchMode (List<Integer> inputData) {
/* 첫 번째 방법
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < mode.length; i++) {
            if (mode[i] > max) {
                max = mode[i];
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < mode.length; i++) {
            if (mode[i] == max) {
                al.add(i);
            }
        }
        Collections.sort(al);
        if (al.size() > 1) result[2] = al.get(1) - 4000;
        else result[2] = al.get(0) - 4000;
*/

        // 두 번째 방법
        HashMap<Integer, Integer> hs = new HashMap<>();

        for (int i : inputData) {
            hs.put(i, hs.getOrDefault(i, 0) + 1);
        }

        int num = 0;
        for (int value : hs.values()) num = Math.max(num, value);
        inputData.clear();
        for (int key : hs.keySet()) {
            if (hs.get(key) == num) inputData.add(key);
        }

        Collections.sort(inputData);
        if (inputData.size() > 1) result[2] = inputData.get(1);
        else result[2] = inputData.get(0);
    }

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        //int N = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> inputData = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            //int temp = sc.nextInt();
            int temp = Integer.parseInt(br.readLine());
            // 최빈값
            //mode[temp + 4000]++;

            // 산술평균
            sum += temp;
            inputData.add(temp);
        }

        calculateAverage(sum, N);
        searchMedianValue(inputData, N);
        searchMode(inputData);
        
        for (int i : result) {
            System.out.println(i);
        }
    }
}
