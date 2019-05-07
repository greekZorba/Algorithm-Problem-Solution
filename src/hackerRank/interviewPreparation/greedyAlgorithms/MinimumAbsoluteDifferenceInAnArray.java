package hackerRank.interviewPreparation.greedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDifferenceInAnArray {

    static int minimumAbsoluteDifference(int[] arr) {

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<arr.length-1; i++) {


            if(minDiff > Math.abs(arr[i]-arr[i+1])) {
                minDiff = Math.abs(arr[i]-arr[i+1]);

                if(minDiff == 0) {
                        break;
                }
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, -3, 71, 68, 17};
        System.out.println(MinimumAbsoluteDifferenceInAnArray.minimumAbsoluteDifference(arr));
    }
}
