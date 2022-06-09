package programmers.Lv2;

import java.util.ArrayList;

public class Pro_수식최대화 {

    private static boolean[] visited = new boolean[3]; // 방문처리 배열
    private static String[] priority = new String[3]; // 조합 담을 배열
    private static String[] arr = {"-", "*", "+"};
    private static ArrayList<String> operator = new ArrayList<>();
    private static ArrayList<Long> operand = new ArrayList<>();
    private static long max = Integer.MIN_VALUE;

    public static long calculate(String op, long op1, long op2) {
        long result = 0;

        switch (op) {
            case "+" :
                result = op1 + op2;
                break;

            case "-" :
                result = op1 - op2;
                break;

            case "*" :
                result = op1 * op2;
                break;
        }
        return result;
    }


    public static void dfs(int depth) {
        if (depth == 3) {
            ArrayList<String> tempOperator = new ArrayList<>();
            tempOperator.addAll(operator);
            ArrayList<Long> tempOperand = new ArrayList<>();
            tempOperand.addAll(operand);
            for (int i = 0; i < priority.length; i++) {
                for (int j = 0; j < tempOperator.size(); j++) {
                    if (priority[i].equals(tempOperator.get(j))) {

                        String op = tempOperator.remove(j);
                        long op1 = tempOperand.get(j);
                        long op2 = tempOperand.remove(j + 1);
                        long ans = calculate(op, op1, op2);
                        tempOperand.set(j, ans);
                        j--;
                    }
                }
            }
            max = Math.max(max, Math.abs(tempOperand.get(0)));
            return;
        }


        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                priority[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static long solution(String expression) {
        long answer = 0;

//        StringTokenizer st = new StringTokenizer(expression, "\\*|-|+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                sb.append(expression.charAt(i));
            }else {
                operand.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                operator.add(String.valueOf(expression.charAt(i)));
            }
        }
        operand.add(Long.parseLong(sb.toString()));
        dfs(0);
        return max;
    }

    public static void main(String[] args) {
        String str1 = "100-200*300-500+20";
        String str2 = "50*6-3*2";
        System.out.println(solution(str1));
    }
}
