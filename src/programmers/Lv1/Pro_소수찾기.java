package programmers.Lv1;

public class Pro_소수찾기 {
    public boolean isPrime(int n) {
        int sqrt = (int)Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    public int solution(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if(isPrime(i)) count++;
        }

        return count;
    }
}
