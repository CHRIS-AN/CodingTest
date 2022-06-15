package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7568
 * bruteForce - 덩치(7568)
 */
public class Boj_덩치 {
    static class Person {
        int weight;
        int height;
        int rank;

        public Person(int weight, int height, int rank) {
            this.weight = weight;
            this.height = height;
            this.rank = rank;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Person p = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            list.add(p);
        }

        for (int me = 0; me < list.size(); me++) {
            int biggerThanMe = N;
            for (int target = 0; target < list.size(); target++) {
                if (me == target) continue;

                if (list.get(me).height >= list.get(target).height || list.get(me).weight >= list.get(target).weight) {
                        biggerThanMe--;
                }
            }
            list.set(me, new Person(list.get(me).weight, list.get(me).height, biggerThanMe));
        }

        StringBuilder sb = new StringBuilder();
        for (Person p : list) {
            sb.append(p.rank).append(' ');
        }
        System.out.println(sb);
    }
}



/*
5
61 185
58 183
88 186
60 175
46 155
*/