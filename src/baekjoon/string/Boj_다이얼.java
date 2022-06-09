package baekjoon.string;

import java.util.Scanner;

public class Boj_다이얼 {

    static int searchNumber (char c) {
        int result = 0;

        switch (c) {
            case 'A' : case 'B' : case 'C' :
                result += 3;
                break;
            case 'D' : case 'E' : case 'F' :
                result += 4;
                break;
            case 'G' : case 'H' : case 'I' :
                result += 5;
                break;
            case 'J' : case 'K' : case 'L' :
                result += 6;
                break;
            case 'M' : case 'N' : case 'O' :
                result += 7;
                break;
            case 'P' : case 'Q' : case 'R' : case 'S' :
                result += 8;
                break;
            case 'T' : case 'U' : case 'V' :
                result += 9;
                break;
            case 'W' : case 'X' : case 'Y' : case 'Z' :
                result += 10;
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int sum = 0;
        for (int i = 0; i < line.length(); i++) {
            sum += searchNumber(line.charAt(i));
        }
        System.out.println(sum);
    }
}
