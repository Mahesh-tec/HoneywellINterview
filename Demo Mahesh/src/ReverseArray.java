import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseArray {

    public static void main(String[] args) {
        Integer[] arr = {10, 20, 30, 40, 50};


//range starts from 1 to arr.length so here length is 5

      /*  IntStream.rangeClosed(1, arr.length)
        Creates a stream of int values from 1 to arr.length (inclusive).
                If arr.length = 5, then the stream will be:1,2,3,4,5

   Step 2: .map(i -> arr[arr.length - i])

For each number i in the stream, we map it to an array element from the end.
Let’s compute it:
When i = 1 → arr[5 - 1] = arr[4] = 50
When i = 2 → arr[5 - 2] = arr[3] = 40
When i = 3 → arr[5 - 3] = arr[2] = 30
When i = 4 → arr[5 - 4] = arr[1] = 20
When i = 5 → arr[5 - 5] = arr[0] = 10
        */

        int[] reversed = IntStream.rangeClosed(1, arr.length)
                .map(i -> arr[arr.length - i])
                .toArray();
        /*List<Integer> list = Arrays.asList(arr);
        Collections.reverse(list);
        System.out.println(list);*/
        System.out.println("Reversed Array: " + Arrays.toString(reversed));

    }
}
