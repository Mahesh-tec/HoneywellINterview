

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MissingNumber {

        public static void main(String[] args) {
            findMissingNumbers();
        }

        public static void findMissingNumbers() {
            // Original list with possible duplicates
            List<Integer> input = Arrays.asList( 6, 2, 6, 8, 18, 13)
                    .stream()//coverts stream
                    .sorted()//sort ascending order
                    .toList(); //converts it back to a List.

            List<Integer> output = new ArrayList<>(); //output : will store the missing numbers.

            //prev is initialized to the first number (2 in sorted list).
            int prev = input.get(0); // Start from the first number (2)

            for (int i = 1; i < input.size(); i++) {
                int current = input.get(i);

                // Add missing numbers between prev and current
                for (int j = prev + 1; j < current; j++) {
                    output.add(j);
                }

                prev = current; // move to next element
            }

            System.out.println("Missing numbers: " + output);
        }
    }


