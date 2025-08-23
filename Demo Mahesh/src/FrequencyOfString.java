import java.util.*;
import java.util.stream.*;
import java.util.function.*;
public class FrequencyOfString {
    public static void main(String[] args) {

        {
            List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");

            Map<String, Long> stationeryCountMap =
                    stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            System.out.println(stationeryCountMap);
        }
    }
}
