package main.practice.manisharana.jsonParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NumberParser implements Parser {

    @Override
    public JsonObject parse(String input) {

        Pattern floatPattern = Pattern.compile("(\\d*)(\\.)(\\d+)");  /*Add +,- as well*/
        Matcher floatMatcher = floatPattern.matcher(input);
        Pattern intPattern = Pattern.compile("^(\\d+)");
        Matcher intMatcher = intPattern.matcher(input);

//        if (floatMatcher.find()) {
//            String matched = floatMatcher.group(1);
//            return new JsonObject(Float.valueOf(matched), input.substring(matched.length()));
//        }

        if (intMatcher.find()) {
            String matched = intMatcher.group(1);
            return new JsonObject(Integer.valueOf(matched), input.substring(matched.length()));
        }

        return null;
    }
}
