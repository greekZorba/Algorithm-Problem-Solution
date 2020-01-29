package leetCode;

public class DecompressRunLengthEncodedList {

    public int[] decompressRLElist(int[] nums) {
        int decompressArrayLength = 0;
        for(int i=0; i<nums.length; i += 2) {
            decompressArrayLength += nums[i];
        }

        int[] decompressArray = new int[decompressArrayLength];
        int decompressArrayIndex = 0;
        for(int i=1; i<nums.length; i += 2) {
            int frequent = nums[i-1];

            for(int j=0; j<frequent; j++) {
                decompressArray[decompressArrayIndex++] = nums[i];
            }
        }

        return decompressArray;
    }

    public static void main(String[] args) {
        DecompressRunLengthEncodedList decompressRunLengthEncodedList
                = new DecompressRunLengthEncodedList();
        int[] nums = new int[]{1,2,3,4};
        int[] result = decompressRunLengthEncodedList.decompressRLElist(nums);
        for(int output : result) {
            System.out.print(output + " ");
        }
    }
}
