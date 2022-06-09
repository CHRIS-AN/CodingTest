package programmers.Lv1;
import java.util.*;

public class Pro_신고결과받기 {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];


        // 신고 당한 횟수를 담아 놓을 자료구조
        Map<String, Integer> reportedTimes = new HashMap<>(id_list.length);

        StringTokenizer st;
        HashSet<String> checkDuplicates = new HashSet<>();
        for (int i = 0; i < report.length; i++) {
            String line = report[i];
            if (checkDuplicates.contains(line)) continue;
            checkDuplicates.add(line);
            st = new StringTokenizer(line); st.nextToken();
            String reportedPerson = st.nextToken();
            reportedTimes.put(reportedPerson, reportedTimes.getOrDefault(reportedPerson, 0) + 1);

        }

        ArrayList<String> temp = new ArrayList<>();
        for (String key : reportedTimes.keySet()) {
            int times = reportedTimes.get(key);
            if (times >= k) {
                // 신고 당한 자 중, 정지 당하는 애들
                searchReporter(key, report, temp);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            for (String s : temp) {
                if (id_list[i].equals(s)) answer[i]++;
            }
        }
        return answer;
    }

    public static ArrayList<String> searchReporter (String reportedPerson, String[] report, ArrayList<String> temp) {
        for (int i = 0; i < report.length; i++) {
            if (report[i].split(" ")[1].equals(reportedPerson)) {
                temp.add(report[i].split(" ")[0]);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String[] report1  = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k1 = 2;

        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k2 = 3;

        solution(id_list2, report2, k2);
    }
}

/*
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < report.length; i++) {
            if (!set.contains(report[i])) {
                set.add(report[i]);
                String reported = report[i].split(" ")[1];
                map.put(reported, map.getOrDefault(reported, 0) + 1);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key) >= k) { // key : neo
                for (int n = 0; n < report.length; n++) {
                    String reporter = report[n].split(" ")[0]; // frodo
                    String reported = report[n].split(" ")[1]; // neo
                    if (key.equals(reported)) {
                        int index = Arrays.asList(id_list).indexOf(reporter);
                         // Arrays.binarySearch(id_list, reporter);
                        answer[index] += 1;
                        // id_list에서 프로도의 인덱스를 찾음
                    }
                }
            }
        }
        return answer;

    }
}
 */