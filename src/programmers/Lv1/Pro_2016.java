package programmers.Lv1;

public class Pro_2016 {
    public String solution(int a, int b) {
        String answer = "";

        int tmpSum = 0;

        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};

        String[] week = {"FRI","SAT","SUN","MON","TUE","WED","THU"};

        for(int forCnt = 0; forCnt < a- 1; forCnt++) {
            tmpSum += month[forCnt];
        }

        tmpSum += b;
        if(tmpSum % 7 == 0) {
            answer = week[week.length - 1];
        }else {
            answer = week[tmpSum % 7 - 1];
        }


        return answer;
    }
}
