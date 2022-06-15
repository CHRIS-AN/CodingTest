package programmers.Lv2;

import java.util.*;

public class Pro_하노이탑 {
    List<ArrayList<Integer>> list = new ArrayList<>();

    public void print (int from, int to) {
        list.add(new ArrayList<Integer>());
        int idx = list.size() - 1;
        list.get(idx).add(from);
        list.get(idx).add(to);
    }

    public void hanoiRecur(int nDisks, int from, int to) {
        if(nDisks == 1) {
            print(from , to);
            return;
        }

        int helpPeg = (6 - from - to);

        hanoiRecur(nDisks - 1, from, helpPeg);
        print(from, to);
        hanoiRecur(nDisks - 1, helpPeg, to);
    }

    public List<ArrayList<Integer>> solution(int n) {
        hanoiRecur(n, 1, 3);
        return list;
    }
}
