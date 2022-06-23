package programmers.Lv1;
import java.util.*;
public class Pro_나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                result.add(arr[i]);
            }
        }
        if(result.isEmpty()) {
            return new int[]{-1};
        }else {
            answer = new int[result.size()];
            int idx = 0;
            for (int i : result) {
                answer[idx++] = i;
            }
            Arrays.sort(answer);
        }
        return answer;
    }
}
