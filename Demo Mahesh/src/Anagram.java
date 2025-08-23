import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagram {
    public static void main(String[] args) {
        String s1 = "CarRace";
        String s2 = "RaceCAr";

       s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
       s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
       if(s1.equals(s2)) {
           System.out.println("These Strings are Anagrams");
       }
       else{
           System.out.println("These strings are not Anagrams");
       }
    }
}
