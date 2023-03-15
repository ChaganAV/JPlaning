import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Element {
    private String begTag="<";
    private String name;
    private String value;
    private String endTag=">";
    private String finTag="</";
    private Attribute[] attributes;

    public Attribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute[] attributes) {
        this.attributes = attributes;
    }

    public Element(String name) {
        this.name = name;
        this.value = "";
    }

    public Element(String name, String value) {
        this.name = name;
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

    @Override
    public String toString() {
        return String.format("%s%s%s%s%s%s%s\n",begTag,getName(),endTag,getValue(),finTag,getName(),endTag);
    }
}
