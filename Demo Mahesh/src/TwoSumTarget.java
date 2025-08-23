import java.util.*;

public class TwoSumTarget {

    public static List<int[]> twoSumAll(int[] nums, int target) {
        List<int[]> results = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                results.add(new int[] { map.get(complement), i });
            }

            map.put(nums[i], i);

            throw new IllegalArgumentException("Target not found due to no elements matched");
        }

        return results;

    }


    public static void main(String[] args) {
        int[] nums = {2,7,11,15,-2};
        int target = 6;

        List<int[]> pairs = twoSumAll(nums, target);

        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
