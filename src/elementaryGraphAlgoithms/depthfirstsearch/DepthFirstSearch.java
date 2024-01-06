package elementaryGraphAlgoithms.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public static void main(String[] args) {
        Node u = new Node("u");
        Node v = new Node("v");
        Node x = new Node("x");
        Node y = new Node("y");
        Node w = new Node("w");
        Node z = new Node("z");

        u.addNeighbor(v);
        u.addNeighbor(x);
        v.addNeighbor(y);
        y.addNeighbor(x);
        x.addNeighbor(v);
        w.addNeighbor(y);
        w.addNeighbor(z);

        List<DepthFirstSearch.Node> nodes = new ArrayList<>();
        nodes.add(u);
        nodes.add(v);
        nodes.add(y);
        nodes.add(x);
        nodes.add(w);
        nodes.add(z);

        dfs(nodes);

        for (DepthFirstSearch.Node node : nodes) {
            System.out.println("Node " + node.name + ": Parent=" + (node.parent != null ? node.parent.name  : "null") + "\t, Distance=" + node.d +"\t, Finish=" + node.f);
        }
    }
    public static int timer = 0;
    private static void dfs(List<Node> nodes){
        for (var node: nodes){
            node.d = Integer.MAX_VALUE;
            node.f = Integer.MAX_VALUE;
            node.parent = null;
            node.color = Color.WHITE;
        }
        timer = 0;
        for (var vertex: nodes){
            if (vertex.color == Color.WHITE)
                dfs_visit(vertex);
        }
    }

    private static void dfs_visit(Node u){
        timer = timer + 1;
        u.d = timer;
        u.color = Color.GRAY;
        for (var v: u.neighbors){
            if (v.color == Color.WHITE){
                dfs_visit(v);
                v.parent = u;
            }
        }
        timer = timer + 1;
        u.color = Color.BLACK;
        u.f = timer;
    }

    private enum Color{
        WHITE,GRAY,BLACK
    }

    private static class Node{
        private final String name;
        private Color color;
        private Node parent;
        private int d;
        private int f;
        private List<Node> neighbors;

        public Node(String name){
            this.name = name;
            this.d = Integer.MAX_VALUE;
            this.f = Integer.MAX_VALUE;
            this.color = Color.WHITE;
            this.parent = null;
            this.neighbors = new ArrayList<>();
        }

        private void addNeighbor(Node neighbor){
            this.neighbors.add(neighbor);
            //neighbor.neighbors.add(this);
        }
    }
}
