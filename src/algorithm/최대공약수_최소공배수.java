package algorithm;

public class 최대공약수_최소공배수 {

    public int gcd_반복문 (int a, int b) {
        while(b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }
        return a;
    }

    public int gcd_재귀 (int a, int b) {
        if (b == 0) return a;
        return gcd_재귀(b, a % b);
    }
    public int lcm (int a, int b) {
        //return a * b / gcd_반복문(a, b);
        return a * b / gcd_재귀(a, b);
    }
    public static void main(String[] args) {

    }
}
