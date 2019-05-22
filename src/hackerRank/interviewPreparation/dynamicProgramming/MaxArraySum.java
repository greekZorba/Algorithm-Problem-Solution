package hackerRank.interviewPreparation.dynamicProgramming;

public class MaxArraySum {

    static int maxSubsetSum(int[] arr) {

        int arrLength = arr.length;
        if(arrLength == 3) {
            return Math.max(arr[2], Math.max(arr[0]+arr[2],arr[0]));
        }
        else if(arrLength == 2) {
            return Math.max(arr[0], arr[1]);
        }
        else if(arrLength == 1) {
            return arr[0];
        }

        // arr에 대해 sum이 최대값인 배열
        int[] maxSumArray = new int[arr.length];
        maxSumArray[0] = arr[0];
        maxSumArray[1] = arr[1];
        maxSumArray[2] = Math.max(arr[2], Math.max(arr[0]+arr[2],arr[0]));

        for(int i=3; i<arrLength; i++) {
            int maxForwardValue = Math.max(maxSumArray[i-2], maxSumArray[i-3]);
            int sumWithForwardValue = arr[i] + maxForwardValue;

            // 현재의 arr 인덱스와 이전의 최대값을 더했는데 지금 arr 인덱스의 값보다 작다면
            // arr 현재 index 값으로 다시 합을 구해주는게 크다
            if(sumWithForwardValue < arr[i]) {
                maxSumArray[i] = arr[i];
                continue;
            }

            if(sumWithForwardValue < maxForwardValue) {
                maxSumArray[i] = maxForwardValue;
            }else {
                maxSumArray[i] = sumWithForwardValue;
            }


        }

        int maxSum = 0;
        for(int i=0; i<arrLength; i++) {

            if(maxSum < maxSumArray[i]) {
                maxSum = maxSumArray[i];
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,-7,8,10};
        System.out.println(MaxArraySum.maxSubsetSum(arr));
    }
}
