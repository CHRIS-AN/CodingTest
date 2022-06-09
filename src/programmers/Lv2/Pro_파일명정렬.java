package programmers.Lv2;
import java.util.Arrays;
import java.util.Comparator;

public class Pro_파일명정렬 {

    static public String[] solution(String[] files) {
        String[] answer = {};
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                boolean isFindHead = false;
                //Head
                String head1 = "";
                int num1 = -1;
                int startNum1 = 0;

                for (int i = 0; i < o1.length(); i++) {
                    if(!isFindHead) {
                        if (Character.isDigit(o1.charAt(i))) {
                            head1 = o1.substring(0, i);
                            System.out.println(head1);
                            isFindHead = true;
                            startNum1 = i;
                        }
                    }else {
                        if (!Character.isDigit(o1.charAt(i))) {
                            num1 = Integer.parseInt(o1.substring(startNum1, i));
                            break;
                        }
                    }
                }
                if (num1 == -1) {
                    num1 = Integer.parseInt(o1.substring(startNum1));
                }


                String head2 = "";
                int num2 = -1;
                int startNum2 = 0;
                isFindHead = false;
                for (int i = 0; i < o2.length(); i++) {
                    if(!isFindHead) {
                        if (Character.isDigit(o2.charAt(i))) {
                            head2 = o2.substring(0, i);
                            isFindHead = true;
                            startNum2 = i;
                        }
                    }else {
                        if (!Character.isDigit(o2.charAt(i))) {
                            num2 = Integer.parseInt(o2.substring(startNum2, i));
                            break;
                        }
                    }
                }
                if (num2 == -1) {
                    num2 = Integer.parseInt(o2.substring(startNum2));
                }

                int result = head1.compareToIgnoreCase(head2);
                // -1 0 1
                // 오름차순 1 2 3
                if (result == 0) {
                    // number
                    if (num1 == num2) {
                        return 0;
                    }else {
                        return num1 - num2;
                    }
                }else {
                    return result;
                }
            }
        });
        System.out.println(Arrays.toString(files));
        return files;
    }

    public static void main(String[] args) {
        String[] str1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] str2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        System.out.println(solution(str1));
    }
}
