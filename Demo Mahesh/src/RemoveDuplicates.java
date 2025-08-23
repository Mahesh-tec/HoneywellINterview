
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
public class RemoveDuplicates {


        public static void main(String[] args)
        {
            List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
            Set<String> uniqueStrngs = new HashSet<>(listOfStrings);
           // List<String> uniqueStrngs = listOfStrings.stream().distinct().collect(Collectors.toList());

            System.out.println(uniqueStrngs);
        }
    }

