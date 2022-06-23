package programmers.Lv1;

public class Pro_자연수뒤집어배열로정렬하기 {
    public int[] solution(long n) {
        String sN = "" + n;
        int len = sN.length();
        int[] answer = new int[len];
        int idx = 0;
        for (int i = len - 1; i >= 0; i--) {
            answer[idx++] = sN.charAt(i) - '0';
        }
        return answer;
    }
}
