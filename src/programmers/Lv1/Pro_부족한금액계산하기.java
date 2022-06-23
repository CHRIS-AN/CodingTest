package programmers.Lv1;

public class Pro_부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long answer = 0;
        for (int i = 1; i <= count; i++) {
            int realPrice = price * i;
            answer += realPrice;
        }

        if (money <= answer) {
            return answer - money;
        }else {
            return 0;
        }
    }
}
