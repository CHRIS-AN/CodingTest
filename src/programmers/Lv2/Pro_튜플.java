package programmers.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Pro_튜플 {

    static public int[] solution(String s) {
        int[] answer = {};

        s = s.substring(2, s.length()-2);

        String sss = s.replace("},{", "-");
        String [] sArr = sss.split("-");


        Arrays.sort(sArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < sArr.length; i++) {
            String[] cArr = sArr[i].split(",");
            for (int j = 0; j < cArr.length; j++) {
                int tempNum = Integer.parseInt(cArr[j]);
                if (!al.contains(tempNum)) {
                    al.add(tempNum);
                }
            }
        }

//        answer = new int[al.size()];
//        Arrays.toString(answer);
        return al.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        String str1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String str2 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        String str3 = "{{123}}";
        System.out.println(solution(str2));
    }
}
