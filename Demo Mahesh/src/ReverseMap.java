import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class ReverseMap {

    public static void main(String[] args){

        Map<Integer,String> a = new HashMap<>();

        a.put(1,"one");
        a.put(2,"two");
        a.put(3,"three");

   Map<Integer,String> revered =  a.entrySet()
                       .stream()
                               .sorted(Map.Entry.<Integer,String>comparingByKey(
        Comparator.reverseOrder()))
        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2) -> e1, LinkedHashMap::new));



      System.out.println(revered);

    }
}
