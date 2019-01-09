package main.practice.manisharana.jsonParser;

class CommaParser {

    JsonObject parse(String input){
        if(input.startsWith(",")){
            return new JsonObject(input.substring(0,1),input.substring(1));
        }

        return null;
    }
}
