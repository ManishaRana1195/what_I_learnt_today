package main.practice.manisharana.jsonParser;

class SpaceParser implements Parser {

    @Override
    public JsonObject parse(String input){
        int i = 0;
        StringBuilder parsedString = new StringBuilder();
        while (input.charAt(i) == ' ' || input.charAt(i) == '\t' || input.charAt(i) == '\n'){
            parsedString.append(input.charAt(i));
            i++;
        }
        if(parsedString.toString().isEmpty()){
            return null;
        }
        return new JsonObject(parsedString, input.substring(i));
    }
}
