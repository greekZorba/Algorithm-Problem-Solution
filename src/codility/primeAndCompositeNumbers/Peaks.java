package codility.primeAndCompositeNumbers;

import java.util.ArrayList;

public class Peaks {

    public static void main(String[] args) {
        Peaks peaks = new Peaks();
        int[] A = new int[]{1,2,3,4,3,4,1,2,3,4,6,2};
        System.out.println(peaks.solution(A));
    }

    // 출처 : https://rafal.io/posts/codility-peaks.html
    public int solution(int[] A) {

        int N = A.length;

        // Find all the peaks
        ArrayList<Integer> peaks = new ArrayList<>();
        for(int i = 1; i < N-1; i++){
            if(A[i] > A[i-1] && A[i] > A[i+1]) peaks.add(i);
        }

        for(int blockSize = 1; blockSize <= N; blockSize++){
            if(N % blockSize != 0) continue; // skip if non-divisible
            int foundPeak = 0;
            int blocks = N/blockSize;
            boolean satisfyCondition = true;

            // Find whether every group has a peak
            for(int peakIdx : peaks){

                // block마다 peak가 있어야함
                if(peakIdx/blockSize > foundPeak){
                    satisfyCondition = false;
                    break;
                }
                if(peakIdx/blockSize == foundPeak) foundPeak++;
            }
            if(foundPeak != blocks) satisfyCondition = false;
            if(satisfyCondition) return blocks;
        }
        return 0;
    }

}
