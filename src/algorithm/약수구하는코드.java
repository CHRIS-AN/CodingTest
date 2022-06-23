package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 약수구하는코드 {
    public static void main(String[] args) {
        int n = 50;
        int sqrt = (int)Math.sqrt(n);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) { // 약수 중 작은 수 저장.
                arr.add(i);
                if (n / i != i) { // 약수 중 큰 수 저장.
                    arr.add(n / i);
                }
            }
        }

        //Collections.sort(arr);
        //arr.sort(Comparator.naturalOrder());
        //arr.sort(Comparator.reverseOrder());

    }
}
