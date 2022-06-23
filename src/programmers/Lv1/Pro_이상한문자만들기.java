package programmers.Lv1;

public class Pro_이상한문자만들기 {
    public String solution(String s) {
        //String answer = "";
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') { // 공백이라면? idx 초기화
                idx = 0;
                sb.append(' ');
            }else {
                // 짝
                if(idx++ % 2 == 0) {
                    sb.append((""+c).toUpperCase());
                }// 홀
                else {
                    sb.append((""+c).toLowerCase());
                }
            }
        }

        return sb.toString();
    }
}
