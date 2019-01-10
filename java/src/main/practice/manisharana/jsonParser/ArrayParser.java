package main.practice.manisharana.jsonParser;

import java.util.Stack;

public class ArrayParser implements Parser {
    @Override
    public JsonObject parse(String input) {
        String result = "";
        JsonObject jsonObject = new JsonObject("", input);
        Stack<Character> bracketStack = new Stack<>();

        while(input.length() > 0){
            char firstChar = input.charAt(0);

            if(firstChar == '[') {
                bracketStack.push(firstChar);
            }

            if(firstChar == ']') {
                bracketStack.pop();
            }
        }

        if(!bracketStack.empty()){
            // error imbalanced brackets
        }

        jsonObject.setObject(result);
        return jsonObject;
    }
}
