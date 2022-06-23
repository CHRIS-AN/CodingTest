package algorithm;

public class 소수를구하는코드 {
    public static void make_prime (int n) {
        if (n < 2) return; // 0과 1은 소수가 아님

        if (n == 2) { // 2는 소수
            System.out.println(n);
            return;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) { // 소수가 아닐 경우 return
                System.out.println("소수가 아닙니다");
                return;
            }
        }
        // 위 반복문을 통과하면, 약수를 갖고 있지 않은 경우임. 즉 소수.
        System.out.println("소수입니다.");
        return;
    }


    // 에라토스테네스의 체
    private static boolean[] prime;
    private static void make_prime_2 (int n) {
        prime = new boolean[n + 1]; // 0 ~ N;

        // 소수가 아닌 idx = true;
        // 소수인 idx = false;

        if(n < 2) return; // 0, 1은 소수 x
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            // 이미 체크된 배열이면 pass
            if (prime[i]) continue;

            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
    public static void main(String[] args) {
        make_prime(10);
        make_prime_2(10);
        for (int i = 0; i < 10; i++) {
            if (!prime[i]) System.out.print(i + " ");
        }
    }
}
