package main.practice.manisharana.jsonParser;

public class BooleanParser {

    public JsonObject parse(String input) {
        String trueFlag = Boolean.TRUE.toString();
        String falseFlag = Boolean.FALSE.toString();
        if (input.startsWith(trueFlag)) {
            return new JsonObject(input.substring(0, trueFlag.length()), input.substring(trueFlag.length()));
        }

        if (input.startsWith(falseFlag)) {
            return new JsonObject(input.substring(0, falseFlag.length()), input.substring(falseFlag.length()));
        }

        return null;
    }
}
