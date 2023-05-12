package greedy;

public class Node {
    String label;
    Integer frequency;
    Node parent ;

    public Node(String label, Integer frequency, Node parent) {
        this.label = label;
        this.frequency = frequency;
        this.parent = parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }


}
