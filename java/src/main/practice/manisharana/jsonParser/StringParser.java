package main.practice.manisharana.jsonParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser implements Parser {

    @Override
    public JsonObject parse(String input){
     //   Pattern stringPattern = Pattern.compile("^(\"?)(\\w+)(\\d*)(\"?)$"); /*Need to add special characters as well as "" */
        Pattern stringPattern = Pattern.compile("^(\\w+)(\\d*)"); /*Need to add special characters as well as "" */
        Matcher matcher = stringPattern.matcher(input);

        if(matcher.find()){
            String matched = matcher.group(1);
            return new JsonObject(matched,input.substring(matched.length()));
        }

        return null;
    }
}
