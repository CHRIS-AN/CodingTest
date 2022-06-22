package programmers.Lv2;

public class Pro_양궁대회 {
    private static int[] result;
    private static int max = Integer.MIN_VALUE;
    private static int[] ans;
    private static boolean flag;
    public static int[] solution(int n, int[] info) {
        result = new int[n];
        ans = new int[11];
        combination(n,0, 0, info);
        return flag ? ans : new int[]{-1};
    }

    private static void combination(int n, int cnt, int idx, int[] apeach) {
        if (cnt == n) {
            int totalApeach = 0;
            int totalLion = 0;

            int[] lion = new int[11];

            for (int i = 0; i < n; i++) {
                lion[10 - result[i]]++; // 라이언이 점수를 맞춘걸 적용
            }

            // 비교하기
            for (int i = 0; i < 11; i++) {
                if (apeach[i] == 0 && apeach[i] == lion[i]) { // 둘 다 0일 시? pass
                    continue;
                }
                if (apeach[i] >= lion[i]) {
                    totalApeach += 10 - i;
                } else {
                    totalLion += 10 - i;
                }
            }

            if (totalLion > totalApeach) {
                if (max < totalLion - totalApeach) {
                    ans = lion;
                    max = totalLion - totalApeach;
                    if(!flag) flag = true;
                }

                else if (max == totalLion - totalApeach) {
                    for (int i = 10; i >= 0; i--) {
                        if (lion[i] < ans[i]) {
                            break;
                        }
                        if (lion[i] > ans[i]) {
                            ans = lion;
                            break;
                        }
                    }
                }
            }// 어피치가 크다면 pass
            return;
        }

        for (int i = idx; i < 11; i++) {
            result[cnt] = i; // 조합 생성 (i를 점수라고 생각하기)
            combination(n,cnt + 1, i, apeach);
        }
    }
}
/*
class Solution {
    private final int TARGET = 11;  // (0~11)
    public int[] solution(int n, int[] info) {
        int[] answer = new int[TARGET];
        int[] temp = new int[TARGET];

        int diffScore = 0;

        for (int i = 1; i < (1 << 10); i++) {
            int ryan = 0;
            int apeach = 0;
            int cnt = 0;

            for (int j = 0; j < TARGET-1; j++) {
                if ((i & (1 << j)) != 0) {
                    ryan += 10 - j; // 라이언이 점수를 가져간다.
                    temp[j] = info[j] + 1; // 어피치보다 라이언이 1번 더 맞춤
                    cnt += temp[j]; // 화살 사용 누적
                }else {
                    temp[j] = 0; // 어피치가 이길 경우? 라이언은 한 발도 쏘지 않음

                    if (info[j] > 0) {
                        apeach += 10 - j; // 어피치가 화살을 쏜 경우라면 어피치가 점수를 가져간다.
                    }
                }
            }

            if (cnt > n) continue; // 만약 화살을 쏠 수 있는 기회를 넘었다면? pass

            temp[10] = n - cnt; // 그게 아닐 시, 0점에 화살 소진
            if (ryan - apeach == diffScore) {
                for (int j = 10; j >= 0; j--) {
                    if(temp[j] > answer[j]) { // 낮은 점수를 더 많이 맞춘 경우
                        diffScore = ryan - apeach;
                        answer = Arrays.copyOf(temp, temp.length);
                        break;
                    }else if (temp[j] < answer[j]) { // 낮은 점수가 더 안 많은 경우는 그냥 pass
                        break;
                    }
                }

            }else if (ryan - apeach > diffScore) { // 라이언이 이긴 경우
                diffScore = ryan - apeach;
                //answer = temp;
                answer = Arrays.copyOf(temp, temp.length); // return 값을 덮어씌우기 (최신화)
            }
        }

        // 라이언이 이기질 못하는 경우 (예외처리)
        if (diffScore == 0) {
            return new int[]{-1};
        }

        return answer;
    }
}
*/