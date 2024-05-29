package lab_20240410.pattern_matching.level_3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceAll {
    public static String replaceAll(String regex, String input, String replaceWith){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.replaceAll(replaceWith);
    }
}
