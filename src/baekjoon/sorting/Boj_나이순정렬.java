package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Boj_나이순정렬 {
    static class OnlineJudgeList {
        int age;
        String name;

        public OnlineJudgeList(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        List<OnlineJudgeList> list = new ArrayList<>();
        String[] line;
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            list.add(new OnlineJudgeList(Integer.parseInt(line[0]), line[1]));
        }

        Collections.sort(list, new Comparator<OnlineJudgeList>() {
            @Override
            public int compare(OnlineJudgeList o1, OnlineJudgeList o2) {
                return o1.age - o2.age;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (OnlineJudgeList member : list) {
            sb.append(member.age).append(' ').append(member.name).append('\n');
        }

        System.out.println(sb);
    }
}

/*
    카운팅 정렬 중요*

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 입력되는 나이의 범위 : 1 ~ 200
		StringBuilder[] p = new StringBuilder[201];

		//객체배열의 인덱스에 각 StringBuilder 객체를 생성해준다.
		for(int i = 0; i < p.length; i++) {
			p[i] = new StringBuilder();
		}

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			// 카운팅 정렬 : 나이를 index 로 하여 해당 배열에 나이와 이름을 append() 한다
			p[age].append(age).append(' ').append(name).append('\n');
		}

		StringBuilder sb = new StringBuilder();
		for(StringBuilder val : p) {
			sb.append(val);
		}

		System.out.println(sb);
	}

	*/