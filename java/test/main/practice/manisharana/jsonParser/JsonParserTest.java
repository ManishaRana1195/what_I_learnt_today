package main.practice.manisharana.jsonParser;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JsonParserTest {

    @BeforeMethod
    public void setUp() {
    }

    @Test
    public void should_parse_comma() {
        String parsed = ",";
        String unparsed = "Life is beautiful";
        String input = parsed + unparsed;
        JsonObject jsonObject = new CommaParser().parse(input);

        assertEquals(jsonObject.getObject(), parsed);
        assertEquals(jsonObject.getUnparsedString(), unparsed);
    }

    @Test
    public void should_return_null_if_comma_is_not_parsed() {
        String input = "Life is beautiful";
        JsonObject jsonObject = new CommaParser().parse(input);

        assertNull(jsonObject);
    }

    @Test
    public void should_parse_space() {
        String parsed = "   \t\n";
        String unparsed = "Life is beautiful";
        String input = parsed + unparsed;
        JsonObject jsonObject = new SpaceParser().parse(input);

       // assertEquals(jsonObject.getObject(), parsed);
        assertEquals(jsonObject.getUnparsedString(), unparsed);
    }

    @Test
    public void should_return_null_if_space_is_not_parsed() {
        String input = "Life is beautiful";
        JsonObject jsonObject = new SpaceParser().parse(input);

        assertNull(jsonObject);
    }
}