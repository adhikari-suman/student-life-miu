package lab_20240410.pattern_matching.level_3;

/*
 Checks whether the input string is a valid identifier.
    File: Ch9MatchJavaIdentifier.java
*/

import javax.swing.*;
import java.util.regex.Pattern;

public class Ch9MatchJavaIdentifier {
    private static final String STOP = "STOP";
    private static final String VALID = "Valid Java identifier";
    private static final String INVALID = "Not a valid Java identifier";

    private static final String VALID_IDENTIFIER_PATTERN
            = "[a-zA-Z][a-zA-Z0-9_$]*";

    public static void main(String[] args) {
        String str, reply;
        while (true) {
            str = JOptionPane.showInputDialog(null, "Identifier:");

            if (str.equals(STOP)) break;
            if (myMatches(VALID_IDENTIFIER_PATTERN, str)) {
                reply = VALID;

            } else {
                reply = INVALID;
            }
            JOptionPane.showMessageDialog(null,
                    str + ":\n" + reply);
        }
    }

    public static boolean myMatches(String regex, String input){
        return Pattern.matches( regex, input);
    }
}

