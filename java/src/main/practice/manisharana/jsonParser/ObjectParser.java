package main.practice.manisharana.jsonParser;

import java.util.ArrayList;
import java.util.Stack;

public class ObjectParser {

    public JsonObject parse(String input){
        int i = 0;
        Stack<Character> bracketStack = new Stack<>();
        JsonObject jsonObject = new JsonObject(null,input);
        while(i< input.length()){
            String character = String.valueOf(input.charAt(i));
            if(character.equals("{")){
                bracketStack.push(input.charAt(i));
                input = input.substring(1);
            }

            switch (character) {
                case " ":
                    jsonObject = new SpaceParser().parse(input);
                    break;
                case ":":
                    jsonObject = new ColonParser().parse(input);
                    break;
                case ",":
                    jsonObject = new CommaParser().parse(input);
                    break;
                default:
                    jsonObject = new StringParser().parse(input);
                    // could be number parser
                    // could be boolean parser
                    // could be array parser
                    break;
            }

            if(character.equals("}")){
               bracketStack.pop();
            }
            i++;
        }

        if(!bracketStack.empty()){
            // raise exception parsing error
        }

        return jsonObject;
    }
}
