package hackerRank;

public class BreakingTheRecords {

    static int[] breakingRecords(int[] scores) {

        int[] breakRecordMaxAndMinCount = new int[2];

        if(scores.length == 1){
            return breakRecordMaxAndMinCount;
        }

        int max = scores[0];
        int min = scores[0];

        int breakMaxCount = 0;
        int breakMinCount = 0;

        for(int i=0; i<scores.length; i++) {

            if(max < scores[i]){
                max = scores[i];
                breakMaxCount++;
            }

            if(min > scores[i]){
                min = scores[i];
                breakMinCount++;
            }
        }

        breakRecordMaxAndMinCount[0] = breakMaxCount;
        breakRecordMaxAndMinCount[1] = breakMinCount;


        return breakRecordMaxAndMinCount;
    }

    public static void main(String[] args) {
        int[] scores = new int[]{10, 5, 20, 20, 4, 5, 2, 25, 1};
        int[] breakRecordMaxAndMinCount = BreakingTheRecords.breakingRecords(scores);

        System.out.println("maxCount : "+breakRecordMaxAndMinCount[0]);
        System.out.println("minCount : "+breakRecordMaxAndMinCount[1]);
    }
}
