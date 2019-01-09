package main.practice.manisharana.jsonParser;

public class JsonObject {
    private Object object;
    private String unparsedString;

    public JsonObject(Object object, String unparsedString) {
        this.object = object;
        this.unparsedString = unparsedString;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getUnparsedString() {
        return unparsedString;
    }

    public void setUnparsedString(String unparsedString) {
        this.unparsedString = unparsedString;
    }
}
