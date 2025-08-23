import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseString {
    public static void main(String[] args) {

        String str = "Interview";

        String reversString = Arrays.stream(str.split(" "))
                .map(word -> new StringBuffer(word).reverse())
                .collect(Collectors.joining());
        System.out.println(reversString);

    }

}
