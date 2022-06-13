package programmers.Lv2;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Pro_기능개발 {
    int day = 0;
    public int[] workProgress (int[] progresses, int[] speeds) {
        // 하루 치 일을 했을 때,
        for (int i = 0; i < progresses.length; i++) {
            progresses[i] += speeds[i];
        }
        day++;
        return progresses;
    }
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> hs = new LinkedHashMap<>();
        for (int i = 0; i < progresses.length; i++) {
            while(progresses[i] < 100) {
                progresses = workProgress(progresses, speeds);
            }
            hs.put(day, hs.getOrDefault(day, 0) + 1);
        }

        for (int key : hs.keySet()) {
            answer.add(hs.get(key));
        }

        return answer;
    }
}
