package test;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> intStream = Stream.iterate(1, (n) -> n + 1);

        Map<Integer, List<Integer>> map = intStream.limit(100)
                .collect(Collectors.groupingBy(n -> n % 3));

        map.forEach(
                (integer, integers) -> {
                    System.out.println("Key: "+ integer);

                   String result =  integers.stream().map(Objects::toString).collect(Collectors.joining(", "));

                    System.out.println(result);
                }
        );
    }
}
