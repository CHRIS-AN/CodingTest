package programmers.Lv1;

public class Pro_로또의_최고순위와최저순위 {
    static int[] rank = {6, 6, 5, 4, 3, 2, 1};
    public static int[] solution(int[] lottos, int[] win_nums) {

        int[] answer = new int[2]; // 최고, 최저 순위를 담을 배열

        int cnt = 0;
        int zeroCnt = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) zeroCnt++;
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) cnt++;
            }
        }

        answer[0] = rank[zeroCnt + cnt];
        answer[1] = rank[cnt];
        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }

    public static void main(String[] args) {
        int[] lottos1 = {44, 1, 0, 0, 31, 25};
        int[] lottos2 = {0, 0, 0, 0, 0, 0};
        int[] lottos3 = {45, 4, 35, 20, 3, 9};

        int[] win_nums1 = {31, 10, 45, 1, 6, 19};
        int[] win_nums2 = {38, 19, 20, 40, 15, 25};
        int[] win_nums3 = {20, 9, 3, 45, 4, 35};

        solution(lottos3, win_nums3);
    }
}
