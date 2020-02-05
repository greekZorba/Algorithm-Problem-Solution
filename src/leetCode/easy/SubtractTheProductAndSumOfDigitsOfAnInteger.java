package leetCode.easy;

public class SubtractTheProductAndSumOfDigitsOfAnInteger {

    public int subtractProductAndSum(int n) {
        String stringN = String.valueOf(n);
        int nLength = stringN.length();
        int[] nArray = new int[nLength];
        for(int i=0; i<nLength; i++) {
            nArray[i] = Character.getNumericValue(stringN.charAt(i));
        }

        int sum = 0;
        int digits = 1;
        for(int i=0; i<nLength; i++) {
            sum += nArray[i];
            digits *= nArray[i];
        }

        return digits-sum;
    }

    public static void main(String[] args) {
        SubtractTheProductAndSumOfDigitsOfAnInteger solution
                = new SubtractTheProductAndSumOfDigitsOfAnInteger();
        System.out.println(solution.subtractProductAndSum(4421));
    }
}
