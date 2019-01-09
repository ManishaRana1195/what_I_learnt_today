package main.practice.manisharana.jsonParser;

public class SpaceParser {

    public JsonObject parse(String input){
        int i = 0;
        StringBuilder parsedString = new StringBuilder();
        while (input.charAt(i) == ' '){
            parsedString.append(" ");
            i++;
        }
        if(parsedString.toString().isEmpty()){
            return null;
        }
        return new JsonObject(parsedString, input.substring(i));
    }
}
