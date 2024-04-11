package lab_20240410.pattern_matching.level_1;

public class ReplaceEveryOccurrenceOf8 {
    public static void main(String[] args) {
        String str = "I am 8 years old. I got 88 cars.";

        str = str.replaceAll("\\b8\\b","eight");

        System.out.println(str);
    }
}
