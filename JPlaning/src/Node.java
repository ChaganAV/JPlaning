public class Node {
    private Element[] element;
    private String[] attributes;
    private Node[] nodes;

    public Node(Element[] element) {
        this.element = element;
    }

    public Node(Element[] element, String[] attributes) {
        this.element = element;
        this.attributes = attributes;
    }

    public Node(Element[] element, String[] attributes, Node[] nodes) {
        this.element = element;
        this.attributes = attributes;
        this.nodes = nodes;
    }
}
