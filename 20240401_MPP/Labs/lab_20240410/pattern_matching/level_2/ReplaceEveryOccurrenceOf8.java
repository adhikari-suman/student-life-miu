package lab_20240410.pattern_matching.level_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceEveryOccurrenceOf8 {
    public static void main(String[] args) {
        String str = "I am 8 years old. I got 88 cars.";


        Pattern pattern = Pattern.compile("\\b8\\b");
        Matcher matcher = pattern.matcher(str);

        String newStr = matcher.replaceAll("eight");

        System.out.println(newStr);
    }
}
