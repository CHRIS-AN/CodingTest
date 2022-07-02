package baekjoon.dataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_후위표기식 {
    public static int swap(int idx) {
        if (idx == 0 || idx == 1) return 1;
        else if (idx == 2 || idx == 3) return 2;
        else return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        Stack<Character> sk = new Stack();
        String operation = "+-*/)(";
        for (int i = 0; i < ch.length; i++) {
            if (!operation.contains(String.valueOf(ch[i])))
                sb.append(ch[i]);
            else { //연산식이 숫자가 아니라면
                if (ch[i] == '(') sk.push(ch[i]);
                else if (ch[i] == ')') { //'('이 나올때까지 문자열에 담아준다.
                    while (!sk.isEmpty() && sk.peek() != '(') {
                        sb.append(sk.pop()); //괄호가 아니면 연산자를 꺼내어 문자열에 담는다.
                    }

                    if (!sk.isEmpty()) sk.pop(); //'('연산자를 꺼내준다.

                } else { // + - / * 연산자 일경우
                    while (!sk.isEmpty() && swap(operation.indexOf(ch[i])) <= swap(operation.indexOf((sk.peek())))) {
                        sb.append(sk.pop());
                    }

                    sk.push(ch[i]);
                }
            }
        }
        while(!sk.isEmpty()) {
            sb.append(sk.pop());
        }
        System.out.println(sb);
    }
}
