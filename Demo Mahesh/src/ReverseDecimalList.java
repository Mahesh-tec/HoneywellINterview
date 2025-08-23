import java.util.*;
import java.util.stream.*;
import java.util.Comparator;

public class ReverseDecimalList {

    public static void main(String[] args)
    {
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);

        List<Double> sortedList = decimalList.stream()
                .sorted(Comparator.reverseOrder())
                /* use Double sortedList = decimaList.stream()
                 .skip(1)
                *  .findFirst()
                *  .get()
                * sout(sortedList); */
                        .collect(Collectors.toList());


        System.out.println(sortedList);
        /*List<Integer> decimalList = Arrays.asList(1,3,9,4,5,7);

        List<Integer> a = decimalList.stream()
                .sorted(Comparator.reverOrder())//Desc order // use only .sorted() get asc order
                .collect(Collectors.toList());*/

    }

}
