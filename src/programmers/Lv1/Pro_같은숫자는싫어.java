package programmers.Lv1;
import java.util.*;
public class Pro_같은숫자는싫어 {
    public int[] solution(int []arr) {

        int pre = -1;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(pre == arr[i]) {
                continue;
            }

            list.add(arr[i]);
            pre = arr[i];
        }
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int i : list) {
            answer[idx++] = i;
        }
        return answer;
    }
}
