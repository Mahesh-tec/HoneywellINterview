

public class ReverseInteger {

    public static void main(String[] args) {


        int num = 54321;

        String reversed = new StringBuilder(String.valueOf(num))
                .reverse()
                .toString();

        int reversedInt = Integer.parseInt(reversed);

        System.out.println(reversedInt);
    }
}
