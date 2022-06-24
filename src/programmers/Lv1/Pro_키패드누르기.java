package programmers.Lv1;
import java.util.*;

public class Pro_키패드누르기 {
    static class Key {
        int x;
        int y;

        public Key (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    List<Key> list = new ArrayList<>();
    public void init () {
        for (int i = 0; i < 4; i++) { // 좌표 값 세팅
            for (int j = 0; j < 3; j++) {
                list.add(new Key(i, j));
            }
        }
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";
        init();
        Map<Integer, Key> hs = new HashMap<>();
        hs.put(0, list.get(10));
        for (int i = 1; i <= 9; i++) {
            hs.put(i, list.get(i-1));
        }

        // 초기값 세팅
        int leftCursor = 9; // *
        int rightCursor = 11; // #

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if(num == 0) num = 11;

            // left
            if(num == 1 || num == 4 || num == 7) {
                sb.append("L");
                // 위치 바꾸기.
                leftCursor = num - 1; // idx 저장
                // right
            }else if(num == 3 || num == 6 || num == 9) {
                sb.append("R");
                rightCursor = num - 1; // idx 저장

                // 2,5,8,0 (가까운 손구락이 이동하기)
            }else {
                int movingX = list.get(num-1).x;
                int movingY = list.get(num-1).y;
                int xL = list.get(leftCursor).x;
                int yL = list.get(leftCursor).y;

                int xR = list.get(rightCursor).x;
                int yR = list.get(rightCursor).y;

                int distL = Math.abs(movingX - xL) + Math.abs(movingY - yL);
                int distR = Math.abs(movingX - xR) + Math.abs(movingY - yR);

                if(distL == distR) {
                    // 주 손가락으로
                    if(hand.equals("left")) {
                        sb.append("L");
                        if(num == 10) leftCursor = num;
                        else leftCursor = num - 1;
                    }else {
                        sb.append("R");
                        if(num == 10) rightCursor = num;
                        else rightCursor = num - 1;
                    }
                }else if (distL < distR) { // L이 가깝다.
                    sb.append("L");
                    if(num == 10) leftCursor = num;
                    else leftCursor = num - 1;
                }else { // R이 가깝다.
                    sb.append("R");
                    if(num == 10) rightCursor = num;
                    else rightCursor = num - 1;
                }
            }
        }
        return sb.toString();
    }
}
