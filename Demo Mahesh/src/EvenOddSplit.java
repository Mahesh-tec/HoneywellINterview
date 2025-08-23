import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvenOddSplit {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 22, 33, 44, 55, 66, 77);

        // Group by even and odd using a boolean condition
        Map<String, List<Integer>> result = numbers.stream()
                .collect(Collectors.groupingBy(n -> (n % 2 == 0) ? "Even" : "Odd"));

       /* Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        List<Integer> evens = partitioned.get(true);
        List<Integer> odds = partitioned.get(false);*/


        System.out.println("Even numbers: " + result.get("Even")); // [22, 44, 66]
        System.out.println("Odd numbers: " + result.get("Odd"));   // [11, 33, 55, 77]
    }
}
