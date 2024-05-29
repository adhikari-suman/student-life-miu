package lab_20240410.pattern_matching.level_2;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LicensePlateMatcher {

    private static final String STOP = "0";
    private static final String VALID = "Valid license plate";
    private static final String INVALID = "Not a valid license plate";

    private static final String VALID_LICENSE_PATTERN
            = "[a-zA-Z]{2}[0-9]{4}[a-zA-Z]{3}";

    public static void main(String[] args) {

        String licenseStr, reply;

        while (true) {
            licenseStr = JOptionPane.showInputDialog("Enter license number");

            if (licenseStr == null || licenseStr.isEmpty() || licenseStr.equals(STOP))
                break;

            Pattern pattern = Pattern.compile(VALID_LICENSE_PATTERN);
            Matcher matcher = pattern.matcher(licenseStr);

            if (matcher.matches()) {
                reply = VALID;
            } else {
                reply = INVALID;
            }

            JOptionPane.showMessageDialog(null, reply);
        }


    }
}
