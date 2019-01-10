package main.practice.manisharana.jsonParser;

public class NullParser implements Parser {
    @Override
    public JsonObject parse(String input) {
        String nullString = "null";
        if (input.startsWith(nullString)) {
            return new JsonObject(input.substring(0, nullString.length()), input.substring(nullString.length()));
        }
        return null;
    }
}
