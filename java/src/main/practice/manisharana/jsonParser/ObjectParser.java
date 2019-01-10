package main.practice.manisharana.jsonParser;

import java.util.Stack;

public class ObjectParser implements Parser {

    @Override
    public JsonObject parse(String input){
        int i = 0;
        /*To see if number of brackets are balanced*/
        Stack<Character> bracketStack = new Stack<>();
        JsonObject jsonObject = new JsonObject("",input);
        StringBuilder result = new StringBuilder();

        while(input.length() > 0){

            String character = String.valueOf(input.charAt(i));
            if(character.equals("{")){
                bracketStack.push(input.charAt(i));
                result.append(character);
                input = input.substring(i+1);
            }

            switch (String.valueOf(input.charAt(i))) {
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
            /*updating the input string*/
            input = jsonObject.getUnparsedString();

            /*append the parsed string together*/
            result.append(jsonObject.getObject());

            String nextChar = String.valueOf(input.charAt(i));
            if(nextChar.equals("}")){
                bracketStack.pop();
                result.append(nextChar);
                input = input.substring(i+1);
            }
        }

        if(!bracketStack.empty()){
            // raise exception parsing error
        }
        jsonObject.setObject(result.toString());
        return jsonObject;
    }
}
