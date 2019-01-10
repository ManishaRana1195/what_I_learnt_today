package main.practice.manisharana.jsonParser;

import java.util.Stack;

public class ObjectParser implements Parser {

    @Override
    public JsonObject parse(String input){
        int i = 0;
        Stack<Character> bracketStack = new Stack<>();
        JsonObject jsonObject = new JsonObject("",input);
        while(i < input.length()){
            String character = String.valueOf(input.charAt(i));
            if(character.equals("{")){
                bracketStack.push(input.charAt(i));
                input = input.substring(i+1);
                character = String.valueOf(input.charAt(i));
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
             //  input = input.substring(i+1);
            }
            i++;
            input = jsonObject.getUnparsedString();
        }

        if(!bracketStack.empty()){
            // raise exception parsing error
        }

        return jsonObject;
    }
}
