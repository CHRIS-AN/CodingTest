package programmers.Lv1;

public class Pro_두정수사이의합 {
    public long solution(int a, int b) {
        long answer = 0;
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        for (int i = small; i <= big; i++) {
            answer += i;
        }
        return answer;
    }
}
