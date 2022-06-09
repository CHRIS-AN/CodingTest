package algorithm;

public class 소수를판별하는코드 {
    public static boolean isPrime3(int num) {
        boolean result = true;
        int end = (int)Math.sqrt(num);
        for(int i = 2; i <= end; i++) {
            if( num%i == 0) {
                result = false;
                break;
                //나누어 떨어지면 더이상 소수가 아니므로 break를 걸어 for문을 끝낸다.
            } else {
                result = true;
            }
        }
        return result;
    }

    /**
     * 출력용
     */
    public static void printPrime(int num) {

        if(isPrime3(num)) {
            System.out.println(num +"는 소수");
        } else {
            System.out.println(num +"는 소수가 아님");
        }
    }

    public static void main(String[] args) {
        printPrime(3733);
    }
}
