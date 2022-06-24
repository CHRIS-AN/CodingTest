package programmers.Lv1;

public class Pro_소수만들기 {
    static int count; // 개수를 세는 용도
    static boolean[] prime = new boolean[50001];
    int[] temp;
    boolean[] visited;

    public void perm (int start, int depth, int[] nums) {
        //base case
        if(depth == 3) {
            int sum = 0;
            for (int i : temp) {
                sum += i;
                System.out.print(i);
            }
            System.out.println();
            if(!prime[sum]) { // 소수니? false 면 소수.

                count++;
            }
            return;
        }

        // recur
        for (int i = start; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[depth] = nums[i];
                perm(i + 1, depth + 1, nums);
                visited[i] = false;
            }
        }
    }

    public void isPrime() {
        // false가 소수이다.
        prime[0] = true; prime[1] = true;

        int sqrt = (int)Math.sqrt(50000);
        for(int i = 2; i <= sqrt; i++) {
            if(prime[i]) continue;

            for (int j = i * i; j <= 50000; j += i) {
                prime[j] = true;
            }
        }
    }

    public int solution(int[] nums) {
        temp = new int[3]; // 세 개의 수.
        visited = new boolean[nums.length];
        isPrime();
        perm(0, 0, nums);

        return count;
    }
}
