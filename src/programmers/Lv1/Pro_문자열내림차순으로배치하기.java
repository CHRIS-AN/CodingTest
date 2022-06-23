package programmers.Lv1;
import java.util.*;
public class Pro_문자열내림차순으로배치하기 {
    public String solution(String s) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i);
            arr.add(a);
        }

        Collections.sort(arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.size(); i++) {
            int a = arr.get(i);
            sb.append((char)a);
        }
        return sb.toString();
    }
}
