package hackerRank.interviewPreparation.sorting;

import java.util.Arrays;

public class MarkAndToys {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {

        Arrays.sort(prices);
        int maximum = 0; // 최대 살 수 있는 장난감 개수

        for(int i=0; i<prices.length; i++) {

            k -= prices[i];

            if(k < 0) {
                break;
            }

            maximum++;
        }

        return maximum;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 12, 5, 111, 200, 1000, 10};
        int k = 50;
        System.out.println(MarkAndToys.maximumToys(prices, k));
    }
}
