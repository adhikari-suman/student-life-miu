package lab_20240410.pattern_matching.level_1;

import javax.swing.*;

public class JapanPhoneNumberValidator {

    private static final String STOP = "0";
    private static final String VALID = "Valid japanese phone number";
    private static final String INVALID = "Not a valid japanese phone number";

    private static final String VALID_LICENSE_PATTERN
            = "[0-9]{2}-[0-9]{3,4}-[0-9]{4}";

    public static void main(String[] args) {

        String phoneStr, reply;

        while (true) {
            phoneStr = JOptionPane.showInputDialog("Enter phone number");

            if (phoneStr == null || phoneStr.isEmpty() || phoneStr.equals(STOP))
                break;

            if (phoneStr.matches(VALID_LICENSE_PATTERN)) {
                reply = VALID;
            } else {
                reply = INVALID;
            }

            JOptionPane.showMessageDialog(null, reply);
        }


    }
}
