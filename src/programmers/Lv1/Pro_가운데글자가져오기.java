package programmers.Lv1;

public class Pro_가운데글자가져오기 {
    public String solution(String s) {
        String answer = "";
        int len = s.length();
        // 5 / 2 = 2...1 -> 홀수일 시? 나눈 값으로 idx 조회
        // 4 / 2 = 2...0 -> 짝수일 시? 나눈 값 - 1 부터 그 다음 idx 까지의 값을 뽑기
        if(len % 2 == 0) {
            //짝수
            int point = len / 2;
            answer = s.substring(point - 1, point + 1);
        }
        else {
            //홀수
            answer = "" + s.charAt(len / 2);
        }
        return answer;
    }
}
