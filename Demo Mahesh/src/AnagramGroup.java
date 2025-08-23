import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramGroup {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("silent", "angel", "quako", "car", "tea", "Listen", "angle", "pasta", "eat");

        input.stream()
                // Group words by their sorted character sequence (to detect anagrams)
                .collect(Collectors.groupingBy(
                        w -> w.toLowerCase()                       // Convert word to lowercase to ignore case
                                .chars()                             // Convert to IntStream of characters
                                .sorted()                            // Sort characters to group anagrams
                                .mapToObj(c -> String.valueOf((char) c)) // Convert sorted int chars back to strings
                                .collect(Collectors.joining())       // Join them into a single sorted key string
                ))
                .values().stream()                             // Get the grouped anagram lists (values only)
                .filter(g -> g.size() > 1)                     // Keep only groups with duplicates (i.e., real anagrams)
                .forEach(System.out::println);                 // Print each group of anagrams


       /* Map<String, List<String>> anagrams = input.stream()
                .collect(Collectors.groupingBy(
                        word -> word.toLowerCase().chars().sorted()
                                .collect(StringBuilder::new,
                                        StringBuilder::appendCodePoint,
                                        StringBuilder::append)
                                .toString()
                ));

        anagrams.values().stream()
                .filter(group -> group.size() > 1)
                .forEach(System.out::println);*/


    }
}
