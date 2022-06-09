package algorithm;

class ArrGraph {

    private int[][] arrGraph;

    public ArrGraph(int initSize) {

        /*
            배열의 idx 가 0부터 시작함으로, ArrayIndexOutOfBoundException 방지를 위해
            정점을 담는 인접행렬의 행과 열 size 는 1을 더하여 초기화 해줌.
         */

        this.arrGraph = new int[initSize+1][initSize+1];
    }

    public int[][] getArrGraph() {
        return this.arrGraph;
    }

    public void putTwoWay(int x, int y) {
        arrGraph[x][y] = arrGraph[y][x] = 1;
    }

    public void putOneWay(int x, int y) {
        arrGraph[x][y] = 1;
    }

    public void printGraphToAdjArr() {
        for (int i = 0; i < arrGraph.length; i++) {
            for (int j = 0; j < arrGraph[i].length; j++) {
                System.out.print(" " + arrGraph[i][j]);
            }
            System.out.println();
        }
    }
}

public class AdjArray {
    public static void main(String[] args) {
        int initSize = 6;
        ArrGraph adjArr = new ArrGraph(initSize);

        adjArr.putTwoWay(1, 2);
        adjArr.putTwoWay(1, 3);
        adjArr.putTwoWay(2, 3);
        adjArr.putTwoWay(2, 4);
        adjArr.putTwoWay(3, 4);
        adjArr.putTwoWay(3, 5);
        adjArr.putTwoWay(4, 5);
        adjArr.putTwoWay(4, 6);

        adjArr.printGraphToAdjArr();
    }
}
