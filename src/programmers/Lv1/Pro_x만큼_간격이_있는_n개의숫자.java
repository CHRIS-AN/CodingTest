package programmers.Lv1;

public class Pro_x만큼_간격이_있는_n개의숫자 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        long temp = 0;
        for (long i = 0; i < n; i++) {
            temp += x;
            answer[(int)i] = temp;
        }

        return answer;
    }
}
