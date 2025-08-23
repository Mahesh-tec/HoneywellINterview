import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class FrequencyEachCharString {

    public static void main(String[] args)
    {
        String inputString = "Mahesh";
        //toLowerCase() if we use this method it will convert all lower case
        //TreeMap::new here used to sort ascending order
        Map<Character, Long> charCountMap =
                inputString.toLowerCase().chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(),TreeMap::new, Collectors.counting()));

        System.out.println(charCountMap);
    }
}
