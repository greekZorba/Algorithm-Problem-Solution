package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BirthdayChocolate {

    static int birthday(List<Integer> s, int d, int m) {
        int output = 0;

        for(int i = 0; i <= s.size()-m; i++){
            int sum = 0;

            for(int j = 0; j<m; j++){
                sum += s.get(i+j);
            }

            if(sum == d){
                output++;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        Integer[] chocolateBars = new Integer[]{1, 1, 1, 1, 1, 1};
        List<Integer> s = Arrays.asList(chocolateBars);
        int d = 3;
        int m = 2;

        System.out.println(BirthdayChocolate.birthday(s,d,m));
    }
}
