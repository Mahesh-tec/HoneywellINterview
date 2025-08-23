import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoSumIndices {

    public static void main(String[] args) {
        int[] nums = {2,7, 11,-2, 15,7};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println(Arrays.toString(result));
    }

        public static int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(); // value -> index

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];

                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }

                map.put(nums[i], i);
            }

            throw new IllegalArgumentException("No two sum solution");
        }


    }


