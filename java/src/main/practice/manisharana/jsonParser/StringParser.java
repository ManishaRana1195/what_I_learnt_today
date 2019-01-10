package main.practice.manisharana.jsonParser;

public class StringParser {

    JsonObject parse(String input){

        if(input.matches("^\\s+\\d*")){
            return new JsonObject(Integer.valueOf(input),"");
        }

        return null;
    }
}
