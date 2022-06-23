package programmers.Lv1;

public class Pro_수박수박수박수박수박수박수 {
    public String solution(int n) {
        int mod = n % 2;
        StringBuilder sb = new StringBuilder();
        if(mod == 0) {
            int roop = n / 2;

            for (int i = 0; i < n / 2; i++) {
                sb.append("수박");
            }
        }else {
            for (int i = 0; i < (n - 1) / 2; i++) {
                sb.append("수박");
            }
            sb.append("수");
        }
        return sb.toString();
    }
}
