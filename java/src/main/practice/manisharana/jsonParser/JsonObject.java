package main.practice.manisharana.jsonParser;

/*Needs to be renamed to ResultObject*/
public class JsonObject {
    private Object object;
    private String unparsedString;

    JsonObject(Object object, String unparsedString) {
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

    @Override
    public String toString() {
        return object.toString();
    }
}
