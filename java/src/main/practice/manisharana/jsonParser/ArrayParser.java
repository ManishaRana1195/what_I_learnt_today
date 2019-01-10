package main.practice.manisharana.jsonParser;

import java.util.Stack;

public class ArrayParser implements Parser {
    @Override
    public JsonObject parse(String input) {
        StringBuilder result = new StringBuilder();
        JsonObject jsonObject = new JsonObject("", input);
        Stack<Character> bracketStack = new Stack<>();

        while(input.length() > 0){
            char firstChar = input.charAt(0);

            if(firstChar == '[') {
                bracketStack.push(firstChar);
                result.append(firstChar);
                input = input.substring(1);
            }

            char nextChar = input.charAt(0);
            if(nextChar == ']') {
                bracketStack.pop();
                result.append(nextChar);
                input = input.substring(1);
            }
        }

        if(!bracketStack.empty()){
            // error imbalanced brackets
        }

        jsonObject.setObject(result.toString());
        return jsonObject;
    }
}
