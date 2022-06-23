package programmers.Lv1;

public class Pro_시저암호 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') { // 공백이 아닌 건? 알파벳
                // n만큼 이동.
                int a = s.charAt(i);
                n %= 26;
                if(65 <= a && a <= 90) { // 대문자
                    System.out.println("대문자 : " +a + " " + (char) a);
                    a += n;

                    if(a > 90) {
                        a -= 26;
                    }
                    System.out.println("대문자(변)) : " +a + " " + (char) a);
                } else { // 소문자
                    System.out.println("소문자 : " +a + " " + (char) a);
                    a += n;
                    if(a > 122) {
                        a -= 26;
                    }
                    System.out.println("소문자(변)) : " + a + " " + (char) a);
                }
                sb.append(""+ (char) a);
            }else {
                // 공백
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
