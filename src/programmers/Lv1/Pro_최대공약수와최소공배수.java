package programmers.Lv1;

public class Pro_최대공약수와최소공배수 {
    public int gcd (int a, int b) {
        // 재귀
        if(b == 0) {
            return a;
        }
        return gcd (b, a % b);
    }

    public int lcm (int gcd, int a, int b) {
        return (a * b) / gcd;
    }

    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int bN = Math.max(n, m);
        int sN = Math.min(n, m);

        answer[0] = gcd(bN, sN);
        answer[1] = lcm(answer[0], bN, sN);

        return answer;
    }
}
