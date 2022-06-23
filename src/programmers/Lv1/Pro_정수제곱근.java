package programmers.Lv1;

public class Pro_정수제곱근 {
    public long solution(long n) {
        long answer = -1;

        for (long i = 1; i <= n; i++) {
            if(i * i == n) {
                answer = (i + 1) * (i + 1);
                break;
            }
        }
        return answer;
    }
}
