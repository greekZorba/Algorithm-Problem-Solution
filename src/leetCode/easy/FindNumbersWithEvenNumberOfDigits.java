package leetCode.easy;

public class FindNumbersWithEvenNumberOfDigits {

    public int findNumbers(int[] nums) {
        int evenNumbers = 0;
        int digits;
        for(int i=0; i<nums.length; i++) {
            digits = String.valueOf(nums[i]).length();

            if(digits % 2 == 0) {
                evenNumbers++;
            }
        }

        return evenNumbers;
    }

    public static void main(String[] args) {
        FindNumbersWithEvenNumberOfDigits findNumbersWithEvenNumberOfDigits
                = new FindNumbersWithEvenNumberOfDigits();
        int[] nums = new int[]{555,901,482,1771};
        System.out.println(findNumbersWithEvenNumberOfDigits.findNumbers(nums));
    }
}
