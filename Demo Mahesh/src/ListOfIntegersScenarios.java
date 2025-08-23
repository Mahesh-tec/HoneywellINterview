import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ListOfIntegersScenarios {

        public static void main(String[] args) {
            List<Integer> list = Arrays.asList(2, 12, 15, 18, 25, 56, 42, 89, 44, 44, 2, 1, 1);

            // Remove duplicates and sort in descending order
            List<Integer> sortedDistinctDesc = list.stream()
                    .distinct()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());

            // Top 3 highest distinct
            List<Integer> top3 = sortedDistinctDesc.stream().limit(3).collect(Collectors.toList());

            // Second highest
            Integer secondHighest = sortedDistinctDesc.stream().skip(1).findFirst().orElse(null);

            // Highest
            Integer highest = sortedDistinctDesc.stream().findFirst().orElse(null);

            // Remove duplicates and sort in ascending order
            List<Integer> sortedDistinctAsc = list.stream()
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());

            // Bottom 3 lowest distinct
            List<Integer> bottom3 = sortedDistinctAsc.stream().limit(3).collect(Collectors.toList());

            // Minimum
            Integer minimum = sortedDistinctAsc.stream().findFirst().orElse(null);

            // Output
            System.out.println("Original List: " + list);
            System.out.println("Top 3 Highest Distinct: " + top3);
            System.out.println("Bottom 3 Lowest Distinct: " + bottom3);
            System.out.println("Highest: " + highest);
            System.out.println("Minimum: " + minimum);
            System.out.println("Second Highest: " + secondHighest);
        }
    }
