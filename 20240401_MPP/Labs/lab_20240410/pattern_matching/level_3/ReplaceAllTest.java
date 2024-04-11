package lab_20240410.pattern_matching.level_3;


import org.junit.Test;

import java.util.regex.Pattern;
import static org.junit.Assert.*;

public class ReplaceAllTest {

    @Test
    public void testReplaceAll8() {

        // Arrange
        String input = "I am 8 years old. I got 88 cars.";
        String regex = "\\b8\\b";
        String replaceWith ="eight";
        String output = "I am eight years old. I got 88 cars.";


        // Act
        String result = ReplaceAll.replaceAll(regex,input,replaceWith);

        // Assert

        assertEquals(output, result);
    }

    @Test
    public void testReplacePartsOfSSNWithX() {

        // Arrange
        String input = "12-123-1234";
        String regex = "\\b[0-9]{2}-[0-9]{3}";
        String replaceWith ="xx-xxx";
        String output = "xx-xxx-1234";


        // Act
        String result = ReplaceAll.replaceAll(regex,input,replaceWith);

        // Assert

        assertEquals(output, result);
    }

    @Test
    public void testReplaceSSNWithX() {

        // Arrange
        String input = "12-123-1234";
        String regex = "\\b[0-9]{2}-[0-9]{3}-[0-9]{4}";
        String replaceWith ="xx-xxx-xxxx";
        String output = "xx-xxx-xxxx";


        // Act
        String result = ReplaceAll.replaceAll(regex,input,replaceWith);

        // Assert

        assertEquals(output, result);
    }


}
