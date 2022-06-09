package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_크로아티아알파벳 {
    static String[] croatiaAlpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        for (int i = 0; i < croatiaAlpha.length; i++) {
            if (line.contains(croatiaAlpha[i])) {
                line = line.replace(croatiaAlpha[i], "*");
            }
        }
        System.out.println(line.length());
    }
}
