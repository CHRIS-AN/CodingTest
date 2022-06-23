package programmers.Lv1;

public class Pro_콜라츠추측 {
    public int solution(long num) {
        if(num == 1) return 0;

        int answer = 0;

        for(int i = 0; i < 500; i++) {
            if(num % 2 == 0) {
                // 짝수
                num /= 2;
            }else {
                // 홀수
                num *= 3;
                num += 1;
            }
            if(num == 1) {
                answer = i+1;
                break;
            }
        }

        if (num != 1) answer = -1;

        return answer;
    }
}
