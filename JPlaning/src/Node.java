public class Node {
    private String name;
    private String beginElement;
    private String endElement;
    private Element[] elements;
    private Attribute[] attributes;
    private Node[] nodes;

    public Node(String name) {
        this.beginElement = String.format("<%s>",name);
        this.endElement = String.format("</%s>",name);
    }

    public Node(Element[] elements, Attribute[] attributes) {
        this.elements = elements;
        this.attributes = attributes;
    }

    public Node(Element[] elements, Attribute[] attributes, Node[] nodes) {
        this.elements = elements;
        this.attributes = attributes;
        this.nodes = nodes;
    }
    public String getBeginElement(){
        return String.format("%s\n",getBeginElement());
    }
    public String getEndElement(){
        return String.format("%s\n",getEndElement());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return String.format("%s\n%s",beginElement,endElement);
    }
}
