import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//import static java.util.stream.Nodes.collect;

public class FirstNonRepeatingChar {

   /* Find first non repetitive character in string using java 8
    String input = "aabbccddeeffgxyzx";*/

    public static void main(String[] args) {

        String input = "aabbccddeeffgxyzx";

        Map<String,Long> charCount = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));

        String  firstNonRepeat = charCount.entrySet()
                .stream()
                .filter(entry ->entry.getValue() == 1)
                .map(entry->entry.getKey())
                .findFirst()
                .get();
        System.out.println(firstNonRepeat);
    }

}


=======================================================

import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

class Main {
    public static void main(String[] args) {
        
       String input = "aaabbbccddefggh";
       
       Map<String, Long> freqCount = input.chars()
                                      .mapToObj(c -> String.valueOf((char)c))
                                      .collect(Collectors.groupingBy(
                                              Function.identity(),
                                              LinkedHashMap::new,
                                              Collectors.counting()
                                      ));

       Optional<String> secondNonRepeated = freqCount.entrySet().stream()
               .filter(entry -> entry.getValue() == 1) // first repeated (.filter(entry -> entry.getValue() > 1))
               .map(entry->entry.getKey())
               .skip(1)
               .findFirst();
               
               
               if(secondNonRepeated.isPresent()){
                    System.out.println("Second non-repeated char: " + secondNonRepeated.get());
               }else{
                    System.out.println("No Second repeated element");
               }
      
    }
}

