package swExpert.diff3;
import java.io.*;
import java.util.*;

public class Sw_새샘이의735게임_2 {
    static HashSet<Integer> hs;
    static int[] inputData;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        inputData = new int[7];
        for (int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            hs = new HashSet<>();
            for (int i=0; i<7; i++) {
                inputData[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, 0);
            List<Integer> sums = new ArrayList<>(hs);
            sums.sort(Collections.reverseOrder());
            System.out.println("#" + t + " " + sums.get(4));
        }
    }
    private static void dfs (int sum, int depth, int idx) {
        if (depth == 3) {
            hs.add(sum);
            return;
        }
        for (int i = idx; i < 7; i++) {
            dfs(sum + inputData[i], depth+1, i+1);
        }
    }
}