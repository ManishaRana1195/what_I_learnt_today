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

    @Test
    public void should_parse_integer_value(){
        String input = "12345";
        JsonObject jsonObject = new NumberParser().parse(input);

        assertTrue(jsonObject.getObject() instanceof Integer);
    }


    @Test
    public void should_parse_float_value(){
        String input = "12345.45";
        JsonObject jsonObject = new NumberParser().parse(input);

        assertTrue(jsonObject.getObject() instanceof Float);
    }

    @Test
    public void should_parse_colon(){
        String parsed = ":";
        String unparsed = "Monty Python";
        String input = parsed + unparsed;

        JsonObject jsonObject = new ColonParser().parse(input);
        assertEquals(jsonObject.getObject(), parsed);
        assertEquals(jsonObject.getUnparsedString(), unparsed);
    }

    @Test
    public void should_parse_json_object(){
        /*should make it pass with quotes*/
        String input = "{  key: value }";
        JsonObject jsonObject = new ObjectParser().parse(input);

        assertEquals(jsonObject.getObject(), input);
    }

    @Test
    public void should_parse_json_object_with_integer(){
        /*should make it pass with quotes*/
        String input = "{  key: 1234 }";
        JsonObject jsonObject = new ObjectParser().parse(input);

        assertEquals(jsonObject.getObject(), input);
    }

    @Test
    public void should_parse_json_object_with_boolean(){
        String input = "{  key: false, key: 123456}";
        JsonObject jsonObject = new ObjectParser().parse(input);

        assertEquals(jsonObject.getObject(), input);
    }

    @Test
    public void should_parse_null(){
        String parsed = "null";
        String unparsed = "Monty ";
        String input = parsed + unparsed;

        JsonObject jsonObject = new NullParser().parse(input);
        assertEquals(jsonObject.getObject(), parsed);
        assertEquals(jsonObject.getUnparsedString(), unparsed);
    }

    @Test
    public void should_parse_json_empty_array(){
        String input = "[ null, null, null ]";
        JsonObject jsonObject = new ArrayParser().parse(input);

        assertEquals(jsonObject.getObject(), input);
    }
}