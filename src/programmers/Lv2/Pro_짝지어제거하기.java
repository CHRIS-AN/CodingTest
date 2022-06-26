package programmers.Lv2;

import java.util.*;

public class Pro_짝지어제거하기 {
    public int solution(String s) {
        int answer = -1;
        Stack<Character> stk = new Stack<>();

        for (char c : s.toCharArray()) {
            if(!stk.isEmpty() && stk.peek() == c) stk.pop();
            else stk.push(c);
        }

        if(stk.isEmpty()) {
            answer = 1;
        }else {
            answer = 0;
        }
        return answer;
    }
}


/*
   final int ALPHABET = 26;
    String[] alpha = {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm", "nn", "oo", "pp", "qq", "rr", "ss", "tt", "uu", "vv", "ww", "xx", "yy", "zz"};
    public int solution(String s) {
        int answer = -1;

        int size = s.length();
        while (true) {
            for(int i = 0; i < ALPHABET; i++) {
                s = s.replaceAll(alpha[i], "");
            }

            // base case
            if(size == s.length()) {
                break;
            }else {
                size = s.length();
            }


        }
        if(s.length() == 0) {
            answer = 1;
        }else {
            answer = 0;
        }
        return answer;
    }
*/