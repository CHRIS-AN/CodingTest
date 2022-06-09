package algorithm;

import java.util.ArrayList;

class ListGraph {
    private ArrayList<ArrayList<Integer>> listGraph;

    public ListGraph(int initSize) {
        this.listGraph = new ArrayList<ArrayList<Integer>>();

        // 안에있는 값들을 초기화를 해줍니다.
        for (int i = 0; i < initSize + 1; i++) {
            listGraph.add(new ArrayList<>());
        }
    }

    public ArrayList<ArrayList<Integer>> getGraph() {
        return this.listGraph;
    }
    public ArrayList<Integer> getNode(int i ) {
        return this.listGraph.get(i);
    }

    // 그래프 추가 (양방향)
    public void putTwoWay(int x, int y) {
        listGraph.get(x).add(y);
        listGraph.get(y).add(x);
    }

    // 그래프 추가 (단방향)
    public void putOneWay(int x, int y) {
        listGraph.get(x).add(y);
    }

    public void printGraphToAdjList() {
        for (int i = 1; i < listGraph.size(); i++) {
            System.out.print("정점 " + i + ": ");
            for (int j = 0; j < listGraph.get(i).size(); j++) {
                System.out.print(" --> " + listGraph.get(i).get(j));
            }
            System.out.println();
        }
    }
}


public class AdjList {
    public static void main(String[] args) {
        int initSize = 6;
        ListGraph adjList = new ListGraph(initSize);

        // 단방향
        // 따로..


        // 양방향
        adjList.putTwoWay(1, 2);
        adjList.putTwoWay(1, 3);
        adjList.putTwoWay(2, 3);
        adjList.putTwoWay(2, 4);
        adjList.putTwoWay(3, 4);
        adjList.putTwoWay(3, 5);
        adjList.putTwoWay(4, 5);
        adjList.putTwoWay(4, 6);

        //System.out.println(adjList.getGraph());
        adjList.printGraphToAdjList();
    }
}
