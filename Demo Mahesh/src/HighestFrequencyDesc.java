import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HighestFrequencyDesc {
    public static void main(String[] args) {
        int[] input = {3, 5, 7, 3, 5, 20, 3, 4, 7, 11, 5, 3, 4};

        List<Integer> result = Arrays.stream(input)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())) // sort by frequency desc
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
/*
        Map<Integer, Long> result = Arrays.stream(input)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())) // sort by value (frequency) descending
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new // maintain insertion order
                ));

        System.out.println(result); // Output: {3=4, 5=3, 7=2, 4=2, 20=1, 11=1}
    }
}
*/
        System.out.println(result); // Output
    }
}
