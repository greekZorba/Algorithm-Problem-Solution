package leetCode.medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * 해답 코드 출처:
 * https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/discuss/470238/JavaC%2B%2BPython-Exactly-Same-as-846.-Hand-of-Straights
 * */
public class DivideArrayInSetsOfKConsecutiveNumbers {

    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> c = new TreeMap<>();
        for (int i : nums) c.put(i, c.getOrDefault(i, 0)+1);
        for (int it : c.keySet())
            if (c.get(it) > 0)
                for (int i = k - 1; i >= 0; i--) {
                    if (c.getOrDefault(it + i, 0) < c.get(it)) return false;
                    c.put(it + i, c.get(it + i) - c.get(it));
                }
        return true;
    }

    public static void main(String[] args) {
        DivideArrayInSetsOfKConsecutiveNumbers divideArrayInSetsOfKConsecutiveNumbers
                = new DivideArrayInSetsOfKConsecutiveNumbers();
//        int[] nums = new int[]{1,2,3,4};
        int[] nums = new int[]{13,14,15,7,8,9,20,21,22,4,5,6};

        int k = 3;
        System.out.println(divideArrayInSetsOfKConsecutiveNumbers.isPossibleDivide(nums, k));
    }
}
