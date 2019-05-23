package hackerRank.interviewPreparation.stringManipulation;

public class SpecialPalindromeAgain {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {

        int count = 0;
        for(int i=0; i<n-1; i++) {
            count++; // 1개 원소 +1
            int beforeCount = 1; // 정중앙 인덱스 만나기 전 동일한 문자 갯수
            int afterCount = 0; // 정중앙 인덱스 만난 후 동일한 문자 갯수
            int encounterCount = 0; // 동일하지 않은 문자를 만났는지 체크

            for(int j=i+1; j<n; j++) {

                // 다른 문자열을 2번 만나면 break;
                if(encounterCount == 2) {
                    break;
                }

                // 다른 문자열을 만난 횟수 count
                if(s.charAt(i) != s.charAt(j)) {
                    encounterCount++;
                    continue;
                }

                if(s.charAt(i) == s.charAt(j)) {

                    // 다른 문자열 만나기 전에 같으면 더함
                    if(encounterCount == 0) {
                        count++; // 다음 문자와 같음
                        beforeCount++;
                    }
                    // 다른 문자열 만난 후 동일한 문자 카운트
                    else if(encounterCount == 1) {
                        afterCount++;
                    }
                }

                // beforeCount 보다 afterCount가 더 큰건 더이상 비교 의미없음
                // afterCount가 올라가는 경우는 다른 문자열을 만난 후 밖에 없음
                if(afterCount == beforeCount) {
                    count++;
                    break;
                }

            }

        }

        // 마지막 원소 +1
        count++;
        return count;
    }

    public static void main(String[] args) {
        int n = 8;
        String s = "mnonopoo";
        System.out.println(SpecialPalindromeAgain.substrCount(n, s));
    }
}
