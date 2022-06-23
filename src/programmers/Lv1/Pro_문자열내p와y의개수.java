package programmers.Lv1;

public class Pro_문자열내p와y의개수 {
    boolean solution(String s) {
        boolean answer = true;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        s = s.toLowerCase();
        int pCnt = 0;
        int yCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) =='p') {
                pCnt++;
            }else if(s.charAt(i) == 'y'){
                yCnt++;
            }
        }
        if(pCnt == 0 && yCnt == 0) return true;
        else if(pCnt != yCnt) return false;
        else {
            return true;
        }
    }
}
