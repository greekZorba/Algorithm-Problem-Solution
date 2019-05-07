package hackerRank.interviewPreparation.greedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {

        List<Integer> importantContests = new ArrayList<>();
        int maximumLuck = 0;
        for(int i=0; i<contests.length; i++) {

            maximumLuck += contests[i][0];

            if(contests[i][1] == 1){
                importantContests.add(contests[i][0]);
            }
        }

        Collections.sort(importantContests); // 오름차순으로 배열
        int subScores = 0; // 빼야할 중요한 시합에서의 운(luck)
        for(int i=0; i<importantContests.size()-k; i++){
            subScores += importantContests.get(i);
        }

        // 2를 곱하는 이유는 최초에 maximumLuck을 계산할 때 subScores가 된 점수도 포함되었기 때문에
        return maximumLuck - 2*subScores;
    }

    public static void main(String[] args) {
        int k = 3;
        int[][] contests = new int[][]{{5,1}, {2,1}, {1,1}, {8,1}, {10,0}, {5,0}};

        System.out.println(LuckBalance.luckBalance(k, contests));
    }
}
