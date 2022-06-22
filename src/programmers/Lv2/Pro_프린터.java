package programmers.Lv2;
import java.util.*;

public class Boj_프린터 {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return -1;
    }
}


/*
    큐로 푼 방식

    public int solution(int[] priorities, int location) {
        Queue<Pair> queue = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Pair(i, priorities[i]));
        }

        while (!queue.isEmpty()) {

            int current = queue.peek().value;

            boolean flag = false;

            for (Pair pair : queue) {
                if (pair.value > current) {
                    // System.out.println(pair.value);
                    flag = true;
                    break;
                }
            }

            if (flag) {
                Pair temp = queue.poll();
                queue.add(temp);
            }
            else {
                answer++;
                Pair pair = queue.poll();

                if (pair.index == location) {
                    return answer;
                }
            }
        }
        return answer;
    }

    class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

*/

/*
    접근은 이후에 잘 맞아 떨어지는 거 같지만, 시간이 너무 오래걸렸음........
    처음부터 class 로 관리를 해서 qu를 사용한다고 생각했어야 함.

   Queue<Integer> quList;
    // 대기목록에 인쇄될 것보다 중요도가 높은 지 루프
    public boolean search() {
        int len = quList.size();
        int target = quList.peek();
        boolean flag = false;
        while(len-- > 0) {
            int a = quList.poll();
            if(target < a) flag = true;
            quList.add(a);
        }

        if (flag) {
            swap();
            return false;
        }else {
            return true;
        }
    }
    public void swap() {
        int target = quList.poll();
        quList.add(target);
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        quList = new LinkedList<>();
        for (int i = 0; i < quList.size(); i++) {
            quList.add(i);
        }

        List<Integer> list = new ArrayList<>();
        while(quList.isEmpty()) {
            if(search()) {
                list.add(quList.poll());
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if(location == list.get(i)) answer = i;
        }
        return answer;
    }
*/

