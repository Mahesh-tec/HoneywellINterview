import java.util.Arrays;

public class Simple {
    //{0,0,1,1,1,2,2} output// 0,0,1,1,2,2

    public static int removeDuplicates(int[] nums){

        if(nums.length <=2) return nums.length;// aray has 2 or few elemts,allowed up to 2

        int index = 2; // 0,1,2 //1,1,1 // valid number, first 2 elemts should be allowed

        for (int i = 2;i< nums.length;i++){ //strt with

            if(nums[i] != nums[index- 2]){
                nums[index++] = nums[i];
            }

        }
        return index;
    }
    public static void main(String[] args){

        int[] nums = {0,0,1,1,1,2,2,3,3,3,4,4,4,};

        int newLength = removeDuplicates(nums);

        int[] result = Arrays.copyOfRange(nums, 0, newLength);
        System.out.println("at most duplicates" +  Arrays.toString(result));
    }
}
