package programmers.Lv1;

public class Pro_자릿수더하기 {
    public int solution(int n) {
        int answer = 0;
        String sN = "" + n;
        for(int i = 0; i < sN.length(); i++) {
            answer += sN.charAt(i) - '0';
        }
        return answer;
    }
}
