package main.practice.manisharana.jsonParser;

import java.util.ArrayList;
import java.util.Stack;

public class ObjectParser implements Parser {

    @Override
    public JsonObject parse(String input) {
        /*To see if number of brackets are balanced*/
        Stack<Character> bracketStack = new Stack<>();
        JsonObject resultJsonObject = new JsonObject("", input);

        StringBuilder result = parseAndGetJsonObject(input, bracketStack);

        if (!bracketStack.empty()) {
            // raise exception parsing error
        }
        resultJsonObject.setObject(result.toString());
        return resultJsonObject;
    }

    private StringBuilder parseAndGetJsonObject(String input, Stack<Character> bracketStack) {
        int i = 0;
        StringBuilder result = new StringBuilder();
        JsonObject tempJsonObject;
        ArrayList<Parser> parserList = getParserList();


        while (input.length() > 0) {
            String character = String.valueOf(input.charAt(i));
            if (character.equals("{")) {
                bracketStack.push(input.charAt(i));
                result.append(character);  // tempJsonObject.setObject(character);
                input = input.substring(i + 1);
            }

            for (Parser parser : parserList) {
                tempJsonObject = parser.parse(input);
                if(tempJsonObject != null){
                    input = tempJsonObject.getUnparsedString();
                    result.append(tempJsonObject.getObject());
                }
            }

            String nextChar = String.valueOf(input.charAt(i));
            if (nextChar.equals("}")) {
                bracketStack.pop();
                result.append(nextChar);
                input = input.substring(i + 1);
            }
        }

        return result;
    }

    private ArrayList<Parser> getParserList() {
        ArrayList<Parser> parsers = new ArrayList<>();
        /*Add array parser later*/
        parsers.add(new BooleanParser());
        parsers.add(new ColonParser());
        parsers.add(new CommaParser());
        parsers.add(new NullParser());
        parsers.add(new NumberParser());
        parsers.add(new SpaceParser());
        parsers.add(new StringParser());
        return parsers;
    }
}
