package programmers.Lv1;

public class Pro_나머지가1이되는수찾기 {
    public int solution(int n) {
        int min = Integer.MAX_VALUE;
        for (int i = 2; i < 1_000_000; i++) {
            if(n % i == 1) {
                min = i;
                break;
            }
        }
        return min;
    }
}
