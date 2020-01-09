package codility.primeAndCompositeNumbers;

import java.util.ArrayList;

public class Flags {

    public static void main(String[] args) {
        Flags flags = new Flags();
        int[] A = new int[]{0, 0, 0, 0, 0, 1, 0, 1, 0, 1};
        System.out.println(flags.solution(A));
    }

    // 참조: https://github.com/ZRonchy/Codility/blob/master/Lesson8/Flags.java
    public int solution(int[] A) {

        ArrayList<Integer> peakIndices = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) peakIndices.add(i);
        }

        if(peakIndices.size() == 1) {
            return 1;
        }

        int distance;
        int maxFlags = 0;
        int startPoint = 1;
        int endPoint = peakIndices.size();

        while(startPoint <= endPoint) {

            int flagCount = (startPoint + endPoint)/2;
            boolean foundFlags = false;
            int selectedFlag = 0;
            int flags = 1;
            for (int i = 1; i < peakIndices.size(); i++) {
                distance = peakIndices.get(i) - peakIndices.get(selectedFlag);

                if (distance / flagCount >= 1) {
                    flags++;
                    selectedFlag = i;
                } else {
                    continue;
                }

                // peak가 2개일 경우로 인해 '==' -> '>='로 변경
                // flags는 peak의 사이즈가 최대라서 flagCount가 flags를 넘어갈 일이 있으면 안됨
                if (flags >= flagCount) {
                    foundFlags = true;
                    maxFlags = flagCount;
                    break;
                }

            }

            if(foundFlags) startPoint = flagCount+1;
            else endPoint = flagCount-1;
        }

        return maxFlags;
    }
}
