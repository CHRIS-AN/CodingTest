package programmers.Lv1;

public class Pro_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] result = new int[n + 1];
        for (int i = 1; i < result.length; i++) {
            result[i] = 1;
        }

        // 1. 도난 처리 싹 먼저하기
        for (int i = 0; i < lost.length; i++) {
            result[lost[i]]--;
        }

        // 2. 여벌 체육복 세팅 하기
        for (int i = 0; i < reserve.length; i++) {
            result[reserve[i]]++;
        }
        int answer = 0;
        // 3. 여벌복 분배
        for (int i = 1 ; i < result.length - 1; i++) {
            if(result[i] == 0) {
                if(i != 1 && result[i] == 0 && result[i - 1] > 1) {
                    result[i-1]--;
                    result[i]++;
                }else if(result[i] == 0 && result[i + 1] > 1) {
                    result[i+1]--;
                    result[i]++;
                }
            }
        }

        int count = 0;
        for (int i : result) {
            if(i != 0) count++;
        }
        return count;
    }
}
