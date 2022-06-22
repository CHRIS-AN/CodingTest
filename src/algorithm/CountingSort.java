package algorithm;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = new int[101];

        // 카운팅 배열 세팅
        for (int i = 0; i < 50; i++) {
            int temp = (int) (Math.random() * 101);
            System.out.print(temp + " "); // 정렬 해야할 숫자.
            arr[temp]++; // counting 배열
        }

        System.out.println("\n"); // 개행

        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println("\n"); // 개행

        // 정렬
        for (int i = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                System.out.print(i + " ");
            }
        }
    }
}
