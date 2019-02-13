package codility.prefixSums;

public class GenomicRangeQuery {
    private static final int IMPACT_FACTOR_OF_A = 1;
    private static final int IMPACT_FACTOR_OF_C = 2;
    private static final int IMPACT_FACTOR_OF_G = 3;
    private static final int IMPACT_FACTOR_OF_T = 4;

    public int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];

        for(int i=0; i < P.length; i++){

            int min = Integer.MAX_VALUE;

            for(int j=P[i]; j <= Q[i]; j++){

                if(min > getImpactFactor(String.valueOf(S.charAt(j)))){

                    min = getImpactFactor(String.valueOf(S.charAt(j)));
                }

            }

            result[i] = min;
        }

        return result;
    }

    private int getImpactFactor(String matchString){

        switch (matchString){
            case "A":
                return IMPACT_FACTOR_OF_A;
            case "C":
                return IMPACT_FACTOR_OF_C;
            case "G":
                return IMPACT_FACTOR_OF_G;
            case "T":
                return IMPACT_FACTOR_OF_T;
            default:
                return Integer.MAX_VALUE;
        }

    }

    /** 시간 복잡도 O(N+M)
     *
     * Reference: https://github.com/ZRonchy/Codility/blob/master/Lesson3/GenomicRangeQuery.java
     * */
    public int[] solution2(String S, int[] P, int[] Q) {
        //used jagged array to hold the prefix sums of each A, C and G genoms
        //we don't need to get prefix sums of T, you will see why.
        /**
         * 여기서 genoms는 각각의 A, C, G의 prefix sum들을 가진 배열이다.
         * T의 prefix sum들은 필요없다. (코드를 보면 알 수 있음)
         * */
        int[][] genoms = new int[3][S.length()+1];

        /**
         * 인덱스 i에서 문자를 발견하면 해당 배열에 1을 대입 아니면 0
         * A를 발견하면 genoms[0] 행에 들어감
         * B를 발견하면 genoms[1] 행에 들어감
         * C를 발견하면 genoms[2] 행에 들어감
         * */
        short a, c, g;
        for (int i=0; i<S.length(); i++) {
            a = 0; c = 0; g = 0;
            if ('A' == (S.charAt(i))) {
                a=1;
            }
            if ('C' == (S.charAt(i))) {
                c=1;
            }
            if ('G' == (S.charAt(i))) {
                g=1;
            }

            genoms[0][i+1] = genoms[0][i] + a;
            genoms[1][i+1] = genoms[1][i] + c;
            genoms[2][i+1] = genoms[2][i] + g;
        }

        int[] result = new int[P.length];
        /**
         * P[]의 값과 Q[]의 값을 시작과 끝의 인덱스로 계산한다.
         * */
        for (int i=0; i<P.length; i++) {
            int fromIndex = P[i]+1;
            int toIndex = Q[i]+1;
            /**
             * 만약 끝과 시작의 인덱스 사이에 문자가 발견된 적 있다면
             * genoms[?][toIndex] - genoms[?][fromIndex-1] > 0 이 되어야 한다.
             * fromIndex-1부터 시작해야 시작 인덱스의 값(fromIndex)과 마지막 인덱스의 값 사이를 비교할 수 있다.
             * */
            if (genoms[0][toIndex] - genoms[0][fromIndex-1] > 0) {
                result[i] = 1;
            } else if (genoms[1][toIndex] - genoms[1][fromIndex-1] > 0) {
                result[i] = 2;
            } else if (genoms[2][toIndex] - genoms[2][fromIndex-1] > 0) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        return result;
    }



    public static void main(String[] args) {
        GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();

        String S = "CAGCCTA";
        int[] P = new int[]{2,5,0};
        int[] Q = new int[]{4,5,6};

        int[] output = genomicRangeQuery.solution(S,P,Q);
        for(int out: output){
            System.out.print(out + " ");
        }
        System.out.println();

        int[] output2 = genomicRangeQuery.solution2(S,P,Q);
        for(int out: output2){
            System.out.print(out + " ");
        }
    }
}
