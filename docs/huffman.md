# Huffman

Huffman is a lossless compression algorithm.

- Idea of huffman:
  - For encode a character to binary form, convert a character to a codeword, based on number of character we use fixed-length codeword or fixed-length binary string. In this situation we reach to a solution that instead of fixed-length codeword use variable-length codeword, and it causes less file volume.

- Local choice(greedy choice): Get two characters of the lowest frequency in each step.

---
### Prove the correctness of the Huffman greedy algorithm:
 - Pre-proof:
   - Theorem: Prefix-code free equivalent to a binary tree.
     1. prove that can make unique prefix-code from binary tree
     2. prove that can make a unique binary tree from each binary prefix-code
 - Proof
   - Optimal tree is a complete tree.
   - Lemma 1.(greedy choice implies an optimal solution)
   - Lemma 2.(optimal substructure)
   - Theorem

---
### Analysis
> Extract-min (dequeue) from a queue take O(logn) time and iterate for loop `n` times, therefore for loop repeat `dequeue` operation n times. So complexity time of construct huffman code is `O(n) * O(logn)` in another word `O(nlogn)`.
```java
public static Node huffman(List<Node> chars){
    int n = chars.size();
    PriorityQueue<Node> priorityQueue =
            new PriorityQueue<Node>(Comparator.comparingInt(i->i.frequency));
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
```

- In above java code of huffman coding algorithm, we use `Priority Queue` data structure because it helps us in each step `dequeue` two characters of the lowest frequency.

- Priority Queue build base on `min-heap` or `max-heap` and it leads to each operation of priority queue spend `O(logn)` time.
