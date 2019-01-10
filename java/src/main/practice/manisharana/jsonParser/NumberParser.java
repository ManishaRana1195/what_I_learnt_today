package main.practice.manisharana.jsonParser;

class NumberParser implements Parser {

    @Override
    public JsonObject parse(String input){

        if(input.matches("\\d*.\\d+")){
            return new JsonObject(Float.valueOf(input),"");
        }

        if(input.matches("^\\d+")){
            return new JsonObject(Integer.valueOf(input),"");
        }

        return null;
    }
}
