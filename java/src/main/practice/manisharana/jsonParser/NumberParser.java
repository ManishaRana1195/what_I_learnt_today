package main.practice.manisharana.jsonParser;

class NumberParser {

    JsonObject parse(String input){

//        if("[0-9]*.[0-9]+".matches(input)){
//            return new JsonObject(Float.valueOf(input),"");
//        }
        if("[0-9]+".matches(input)){
            return new JsonObject(Integer.valueOf(input),"");
        }

        return null;
    }
}
