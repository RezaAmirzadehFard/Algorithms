package elementaryGraphAlgoithms.breadthfirstsearch;

import java.util.*;

class BreadthFirstSearch{
    public static void main(String[] args){

        Node s = new Node("s");
        Node t = new Node("t");
        Node y = new Node("y");
        Node u = new Node("u");
        Node v = new Node("v");
        Node r = new Node("r");
        Node w = new Node("w");
        Node x = new Node("x");
        Node z = new Node("z");

        s.addNeighbor(u);
        s.addNeighbor(r);
        s.addNeighbor(v);
        t.addNeighbor(u);
        t.addNeighbor(r);
        y.addNeighbor(x);
        y.addNeighbor(u);
        y.addNeighbor(v);
        u.addNeighbor(s);
        u.addNeighbor(t);
        u.addNeighbor(y);
        v.addNeighbor(s);
        v.addNeighbor(w);
        v.addNeighbor(y);
        r.addNeighbor(s);
        r.addNeighbor(w);
        r.addNeighbor(t);
        w.addNeighbor(r);
        w.addNeighbor(v);
        w.addNeighbor(z);
        w.addNeighbor(x);
        z.addNeighbor(x);
        z.addNeighbor(w);

        List<Node> nodes = new ArrayList<>();
        nodes.add(s);
        nodes.add(u);
        nodes.add(t);
        nodes.add(y);
        nodes.add(w);
        nodes.add(x);
        nodes.add(z);
        nodes.add(v);
        nodes.add(r);

        // Run BFS with the first node as the root
        BFS(nodes, s);

        // Print the resulting parent-child relationships
        for (Node node : nodes) {
            System.out.println("Node " + node.name + ": Parent=" + (node.parent != null ? node.parent.name  : "null") + "\t, Distance=" + node.d);
        }
    }

    private static void BFS(List<Node> nodes, Node root){
        for (var vertex: nodes){
            vertex.d = 0;
            vertex.parent = null;
            vertex.color = Colors.WHITE;
        }
        root.d = 0;
        root.color = Colors.GRAY;
        root.parent = null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node u = queue.poll();
            for(var v: u.neighbors){
                if (v.color == Colors.WHITE) {
                    v.d = u.d + 1;
                    v.color = Colors.GRAY;
                    v.parent = u;
                    queue.add(v);
                }
            }
            u.color = Colors.BLACK;
        }
    }

    private enum Colors{ WHITE, GRAY, BLACK }

    private static class Node{
        private final String name;
        private int d;
        private Colors color;
        private Node parent;
        private List<Node> neighbors;

        public Node(String name) {
            this.name = name;
            this.d = Integer.MAX_VALUE;
            this.color = Colors.WHITE;
            this.parent = null;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node neighbor) {
            this.neighbors.add(neighbor);
            neighbor.neighbors.add(this);
        }
    }
}