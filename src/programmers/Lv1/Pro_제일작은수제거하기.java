package programmers.Lv1;

public class Pro_제일작은수제거하기 {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};

        int[] answer = new int[arr.length - 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
            }
        }
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != min) {
                answer[idx++] = arr[i];
            }
        }

        return answer;
    }
}
