package programmers.Lv1;
import java.util.*;

public class Pro_정수내림차순정렬하기 {
    public long solution(long n) {
        long answer = 0;

        List<Integer> list = new ArrayList<>();
        String sN = "" + n;
        for (int i = 0; i < sN.length(); i++) {
            list.add(sN.charAt(i) - '0');
        }

        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }

        return Long.parseLong(sb.toString());
    }
}
