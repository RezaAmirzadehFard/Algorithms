package minimumSpanningTree;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Kruskal {

    public static void MST_Kruskal(List<Node> graph, List<Edge> w){
        Set<Node> A = Collections.emptySet();
        for (var vertex: graph){
            makeSet(vertex);
        }

    }

    public static void makeSet(Node x){
        x.parent = x;
        x.rank = 0;
    }

    private static void union(Node x, Node y){
        link(findSet(x), findSet(y));
    }

    private static void link(Node x, Node y){
        if (x.rank > y.rank){
            y.parent = x;
        } else{
            x.parent = y;
            if (x.rank == y.rank)
                y.rank = y.rank + 1;
        }
    }


    private static Node findSet(Node x){
        if (x != x.parent)
            x.parent = findSet(x.parent);
        return x.parent;
    }

    private static class Node{
        private String label;
        private Node parent;
        private int rank;


        public Node(String label){
            this.label = label;
            this.parent = null;
            this.rank = -1;
        }
    }

    private static class Edge{
        private Node start;
        private Node destination;
        private int weight;

        private Edge(){
            this.weight = 0;
        }
    }
}
