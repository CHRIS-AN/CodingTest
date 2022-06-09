package programmers.Lv2;

import java.util.Stack;

public class Pro_짝짓기 {

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
            }else {
                char tmp = stack.peek();
                if (tmp == c) stack.pop();
                else stack.add(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("cdcd"));
    }
}