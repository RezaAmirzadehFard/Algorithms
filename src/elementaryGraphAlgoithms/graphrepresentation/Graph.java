package elementaryGraphAlgoithms.graphrepresentation;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public static void main(String[] args) {
        AdjacencyMatrix graph = new AdjacencyMatrix(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

       // System.out.print(graph.toString());
    }

    // for undirected graph
    static class AdjacencyMatrix{
        private int[][] adjMatrix;
        private int verticesNum;

        public AdjacencyMatrix(int verticesNum){
            this.verticesNum = verticesNum;
            this.adjMatrix = new int[verticesNum][verticesNum];
        }

        private void addEdge(int i, int j){
            adjMatrix[i][j] = 1;
            adjMatrix[j][i] = 1;
        }

        private void removeEdge(int i, int j){
            adjMatrix[i][j] = 0;
            adjMatrix[j][i] = 0;
        }
        /*public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < verticesNum; i++) {
                s.append(i + ": ");
                for (int j : adjMatrix[i]) {
                    s.append((j >= 1 ? j : 0) + " ");
                }
                s.append("\n");
            }
            return s.toString();
        }*/
    }

    static class AdjacencyList{
        private List<List<Integer>> graph;


    }
}
