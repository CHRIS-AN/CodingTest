package programmers.Lv2;

public class Pro_큰수만들기 {
    static public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");
        //int changingLastIdx = number.length() - k;
        int setStartIdx = 0;

        while(setStartIdx < number.length()) {
            int leftNum = k + answer.length() + 1;
            int max = 0;
            for (int j = setStartIdx; j < leftNum; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    setStartIdx = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}
