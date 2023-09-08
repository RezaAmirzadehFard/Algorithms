package greedy;


import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class HuffmanCoding {
    
    public Node huffman(List<Node> Nodes){
        Queue<Node> queue = new PriorityQueue(Nodes);

        while (queue.size() > 0){
            Node u = queue.poll();
            Node v = queue.poll();
            Node z = new Node("z", 0, null);

            z.setFrequency(u.getFrequency() + v.getFrequency());
            u.setParent(z);
            v.setParent(z);

            queue.add(z);
        }
        return queue.peek();
    }
}
