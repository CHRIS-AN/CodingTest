package programmers.Lv1;

public class Pro_문자열다루기기본 {
    public boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6) {
            for (int i = 0; i < s.length(); i++) {
                if(!Character.isDigit(s.charAt(i))) {
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }
}
