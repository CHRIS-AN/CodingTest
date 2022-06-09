package programmers.Lv2;

public class Pro_모음사전 {
    
    private static String[] vowels = {"A","E","I","O","U"};
    private static int count;
    private static boolean flag;

    public static void dfs(String target, String word) {
        if (word.equals(target)) {
            flag = true;
            return;
        }

        if (target.length() == 5) {
            return;
        }
        for (int i = 0; i < vowels.length; i++) {

            count++;
            dfs(target + vowels[i], word);

            if(flag) break;
        }
    }

    public static int solution(String word) {
        int answer = 0;

        return answer;
    }

    public static void main(String[] args) {
        dfs("", "AAAAE");
        System.out.println(count);
    }
}
