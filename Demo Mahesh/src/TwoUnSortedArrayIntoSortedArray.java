import java.util.Arrays;
import java.util.stream.IntStream;


public class TwoUnSortedArrayIntoSortedArray {
    public static void main(String[] args) {
        int[] a = new int[]{2,4,8,9,10};

        int[] b = new int[]{3,4,5,7,9,6,1};

        int[] c = IntStream.concat(Arrays.stream(a),Arrays.stream(b)).sorted().distinct().toArray();

        System.out.println(Arrays.toString(c));

    }
}
