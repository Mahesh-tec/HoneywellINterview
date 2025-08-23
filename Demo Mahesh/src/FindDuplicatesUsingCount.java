import java.util.*;
import java.util.stream.*;
public class FindDuplicatesUsingCount {

    public static void main(String[] args) {
        String input = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();

        Map<String, Long> charCounts = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

        charCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > 1) // only duplicates
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }
}
