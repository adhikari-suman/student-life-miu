package lab_20240416_w3d2.level_1;

import java.util.List;
import java.util.stream.Stream;

public class Problem3 {

    public static void main(String[] args) {
        List<String> words = List.of("Hi", "/", "Hello", "World", "Today", "is", "a", "beautiful", "day");

        int result = new Problem3().countWords(words, 'H', 'd', 5);

        System.out.println("Result: " + result);

        int result1 = new Problem3().countWords(words, 'o', 'y', 5);

        System.out.println("Result: " + result1);

        /**
         * Solution 3.b
         */
        Stream strings = Stream.of("A", "good", "day", "to", "write", "some", "Java");

        System.out.println(strings.reduce((a, b) -> a + " " + b).orElse(""));

        /**
         * Solution 3.c -> Practice Optional bindings
         */
        Stream<String> strings1 = Stream.of("A", "good", "day", "to", "write", "some", "Java");
        String result2 = strings1.filter(s-> !s.endsWith("o")).findFirst().orElseGet(()->"");

        System.out.println(result2);
    }


    // Solution 3.a
    public int countWords(List<String> words, char c, char d, int len) {
        return (int) words.stream()
                .filter(word -> word.contains("" + c) && !word.contains("" + d))
                .count();
    }

}
