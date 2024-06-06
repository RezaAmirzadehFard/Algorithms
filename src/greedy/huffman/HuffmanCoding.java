package greedy.huffman;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HuffmanCoding {
    public static void main(String[] args){
        List<Node> characters = new ArrayList<>();
        Node a1 = new Node();
        Node a2 = new Node();
        Node a3 = new Node();
        Node a4 = new Node();
        Node a5 = new Node();
        Node a6 = new Node();
        a1.c = "a";
        a2.c = "b";
        a3.c = "c";
        a4.c = "d";
        a5.c = "e";
        a6.c = "f";
        a1.frequency = 45;
        a2.frequency = 13;
        a3.frequency = 12;
        a4.frequency = 16;
        a5.frequency = 9;
        a6.frequency = 5;

        characters.add(a1);
        characters.add(a2);
        characters.add(a3);
        characters.add(a4);
        characters.add(a5);
        characters.add(a6);

        System.out.println(huffman(characters));
    }

    public static Node huffman(List<Node> chars){
        int n = chars.size();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(Comparator.comparingInt(i->i.frequency));
        priorityQueue.addAll(chars);

        for (int i = 0; i < n - 1; i++) {
            Node z = new Node();
            Node x = priorityQueue.poll();
            Node y = priorityQueue.poll();
            z.left = x;
            z.right = y;
            z.frequency = x.frequency + y.frequency;
            z.c = x.c + y.c;
            priorityQueue.add(z);
        }
        return priorityQueue.peek();
    }

    private static class Node {
        String c;
        Node left;
        Node right;
        int frequency;

        private String toString(int indent) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < indent; i++) {
                result.append("-");
            }
            result.append("<").append(this.c + ":" + this.frequency).append(">\n");
            if (this.left != null) {
                for (int i = 0; i < indent; i++) {
                    result.append("-");
                }
                result.append("L:\n");
                result.append(this.left.toString(indent + 2));
            }
            if (this.right != null) {
                for (int i = 0; i < indent; i++) {
                    result.append("-");
                }
                result.append("R:\n");
                result.append(this.right.toString(indent + 2));
            }

            return result.toString();
        }

        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append("<");
            result.append(this.c + ":" + this.frequency);
            result.append(">\n");

            if (this.left != null) {
                result.append("L:\n");
                result.append(this.left.toString(2));
            }
            if (this.right != null) {
                result.append("R:\n");
                result.append(this.right.toString(2));
            }

            return result.toString();
        }
    }

}
