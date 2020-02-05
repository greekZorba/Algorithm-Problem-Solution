package leetCode.easy;

import java.math.BigInteger;

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if(num == 1) {
            return true;
        }
        int start = 1;
        int end = num/2;

        while(start <= end) {
            int sqrtInput = (start+end)/2;
            long squareRoot = (long)sqrtInput * (long)sqrtInput;
            if(num == squareRoot) {
                return true;
            } else if(num > squareRoot) {
                start = sqrtInput + 1;
            } else {
                end = sqrtInput - 1;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        System.out.println(validPerfectSquare.isPerfectSquare(808201));
    }
}
