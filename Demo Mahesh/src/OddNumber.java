import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OddNumber {

        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

            List<Integer> odd = numbers.stream()
                    .filter(n -> n % 2 != 0)
                    .collect(Collectors.toList());

            System.out.println(odd); // Output: [1, 3, 5]
        }
    }


