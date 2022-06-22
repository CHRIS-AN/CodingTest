package programmers.Lv2;

public class Pro_문자열압축 {
    public static int solution(String s) {
        int len = s.length();
        if (len == 1) return 1;
        int min = Integer.MAX_VALUE;

        for (int cpSize = 1; cpSize <= len / 2; cpSize++) {
            int count = 1;
            int mod = len % cpSize;
            int sLength = mod;
            int lastCursor = len - mod - (2 * cpSize);

            for (int i = 0; i <= lastCursor; i += cpSize) {
                String first = s.substring(i, i + cpSize);
                String second = s.substring(i + cpSize, i + (2 * cpSize));

                // first 랑 second 같을 때
                if (first.equals(second)) {
                    count++;
                    if (i == lastCursor)
                        sLength += cpSize + String.valueOf(count).length();
                }

                //first 랑 second 다를 때
                else {
                    if (i == lastCursor) sLength += cpSize;

                    if (count > 1) {
                        sLength += cpSize + String.valueOf(count).length();
                    }else {
                        sLength += cpSize;
                    }

                    count = 1; // 다시 cnt 초기화
                }
            }

            min = Math.min(sLength, min);
        }
        return min;
    }
}
