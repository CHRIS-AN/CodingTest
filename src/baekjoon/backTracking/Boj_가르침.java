package baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_가르침 {
    static int N, K;
    static boolean[] visited = new boolean[26];
    static HashSet<Character> hs = new HashSet<>();
    static ArrayList<Character> al = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static String[] line;

    /* dfs 함수 로직
        가르칠 수 있는 수를 가지고 방문처리를(true / false)로 알파벳 조합을 만듭니다.
        조합은 visited 방문처리 ture 된 것이 사용가능한 조합이라 생각합니다.
     */
    private static void dfs(int start, int depth) {
        if (depth == K - 5) {
            isEligibilityCheck();
            return;
        }

        for (int i = start; i < al.size(); i++) {
            char c = al.get(i);
            visited[c - 'a'] = true;
            dfs(i + 1, depth + 1);
            visited[c - 'a'] = false;
        }
    }

    /* isEligibilityCheck 함수 로직
        dfs 에서 조합한 알파벳을 가지고, 입력 받은 단어 중에 사용 가능한 단어가 몇 개 있는 지 확인을 합니다.
     */
    private static void isEligibilityCheck() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            boolean flag = true;
            for (int j = 0; j < line[i].length(); j++) {
                char c = line[i].charAt(j);
                if (!visited[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
        max = Math.max(max, count);
    }

    // 이 메서드 역할은 최소 필요한 알파벳 "a, c, i, n ,t" 의 갯수 조차 안될 시, false
    // 또한, 아까 HashSet 에 빼면서 최소로 필요한 알파벳("a, c, i, n ,t" )이 방문 처리가 안됐을 시, 애당초 단어를 못 만듭니다. 그러니 false
    private static boolean init() {
        if (K < 5) return false;
        if (!(visited['a' - 'a'] && visited['c' - 'a'] && visited['i' - 'a'] && visited['n' - 'a'] && visited['t' - 'a'])) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        line = new String[N];

        /* for 문 내에 for 문 로직
            이 과정에선 HashSet 자료구조를 이용하여, 총 단어의 알파벳이 중복을 피하고, 어떤 종류의 알파벳이 있는지 구별하기 위함입니다.
         */
        for (int i = 0; i < N; i++) {
            line[i] = br.readLine();
            for (int j = 0; j < line[i].length(); j++) {
                hs.add(line[i].charAt(j));
            }
        }
        /* for 문 내에 if 문 로직
            총 단어의 알파벳을 하나씩 뽑아서, 꼭 들어있어야하는 조건 "a, c, i, n ,t" 알파벳이 있다면, 방문처리 true 처리 합니다.
         */
        for (char c : hs) {
            if (c == 'a' || c == 'c' || c == 't' || c == 'i' || c == 'n') {
                visited[c - 'a'] = true;
            // "a, c, i, n ,t" 제외하곤, list 에 담아 놓습니다.
            }else al.add(c);
        }

       /* if 로직
            최소한의 기본 세팅이 안됐을 시, 0을 return
        */
        if (!init()) {
            System.out.println(0);
            return;
        }

        /* if else 로직.
             위 과정을 다 처리한 뒤에선, 최소 알파벳인 "a, c, i, n ,t" 이 존재할 것이며,
             al 이라는 ArrayList 에 최소 알파벳을 제외한 알파벳이 담겨져 있을 것입니다.
         */

        if (K-5 >= al.size()) max = N; // 만약 조합해야 할 알파벳 보다, 가르칠 수 있는 알파벳이 많다면? 그냥 모든 단어를 사용할 수 있다.
        else dfs(0, 0); // 그게 아닐 시, dfs 로 조합 시작
        System.out.println(max);

    }
}
