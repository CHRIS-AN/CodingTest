package programmers.Lv2;

import java.util.*;

public class Pro_단체사진찍기 {
    private boolean[] visited;
    private Map<Character, Integer> hs = new HashMap<>();
    private int count;
    private int[] perm; // 순열 조합을 위한 temp int[0] = 어피치의 위치, int[1] = 콘의 위치 ..... int[7] = 튜브의 위치

    public boolean isPossible(String[] data) {
        for (int i = 0; i < data.length; i++) {
            int fPos = perm[hs.get(data[i].charAt(0))];
            int sPos = perm[hs.get(data[i].charAt(2))];
            int diff = Math.abs(fPos - sPos) - 1;
            char oper = data[i].charAt(3);
            int gap = data[i].charAt(4) - '0';

            switch(oper) {
                case '=' :
                    if(!(diff == gap)) return false;
                    break;
                case '>' :
                    if(!(diff > gap)) return false;
                    break;
                case '<' :
                    if(!(diff < gap)) return false;
                    break;
            }
        }
        return true;
    }

    public void backTracking (int depth, String[] data) {
        // base case
        if (depth == 8) {
            if(isPossible(data)) {
                count++;
            }
            return;
        }
        // recur
        for (int i = 0; i < 8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                perm[depth] = i;
                backTracking(depth + 1, data);
                visited[i] = false;
            }
        }
    }
    public void init() {
        hs.put('A', 0);
        hs.put('C', 1);
        hs.put('F', 2);
        hs.put('J', 3);
        hs.put('M', 4);
        hs.put('N', 5);
        hs.put('R', 6);
        hs.put('T', 7);
    }
    public int solution(int n, String[] data) {
        visited = new boolean[8];
        perm = new int[8];
        init();
        backTracking(0, data);

        return count;
    }
}