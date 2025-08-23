import java.util.*;
import java.util.stream.Collectors;


public class IntegerOperations {
    public static void main(String[] args) {
       List<Integer> num = Arrays.asList(1,5,2,8,7,9);

        // Reverse the number
        Collections.reverse(num);

        //find max number

        int max = num.stream().max(Comparator.naturalOrder()).get();
//find min
        int min = num.stream().min(Comparator.naturalOrder()).get();

//find top 3

        // find top 3 (highest numbers)
        List<Integer> top3 = num.stream()
                .sorted(Comparator.reverseOrder()) // sort descending
                .limit(3)                          // pick first 3
                .collect(Collectors.toList());

        // find bottom 3 (smallest numbers)
        List<Integer> bottom3 = num.stream()
                .sorted()                          // ascending
                .limit(3)                          // pick first 3
                .collect(Collectors.toList());

        System.out.println("Reversed Array : " + num);
        System.out.println("min number :" + min);
        System.out.println("max number :" + max);
        System.out.println("top 3 numbers : " + top3);
        System.out.println("bottom 3 numbers : " + bottom3);

    }
}
