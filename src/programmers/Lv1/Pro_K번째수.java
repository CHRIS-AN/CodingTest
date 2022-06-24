package programmers.Lv1;
import java.util.*;
public class Pro_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int i = 0; i < commands.length; i++) {
            int[] con = commands[i];
            List<Integer> list = new ArrayList<>();
            for(int j = con[0]-1; j < con[1]; j++) {
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[idx++] = list.get(con[2]-1);
        }
        return answer;
    }
}
