public class Element {
    private String begTag="<";
    private String name;
    private String value;
    private String endTag=">";
    private String finTag="</";

    public Element(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}