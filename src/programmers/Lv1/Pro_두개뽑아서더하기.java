package programmers.Lv1;
import java.util.*;
public class Pro_두개뽑아서더하기 {
    public int[] solution(int[] numbers) {

        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                hs.add(numbers[i] + numbers[j]);
            }
        }

        List<Integer> list = new ArrayList<>(hs);
        Collections.sort(list);

        int[] answer = new int[list.size()];
        int idx = 0;
        for(int i : list) {
            answer[idx++] = i;
        }
        return answer;
    }
}
