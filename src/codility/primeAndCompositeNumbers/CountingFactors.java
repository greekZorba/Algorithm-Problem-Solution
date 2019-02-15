package codility.primeAndCompositeNumbers;

public class CountingFactors {

    public int solution(int N) {
        int countOfFactors = 0;
        long divisor = 1;

        /** 동시에 서로 대칭되는 약수가 루트 N보다 커질 수 없다. */
        while(divisor * divisor < N){
            if(N % divisor == 0){
                /**서로 대칭되는 약수가 있어서 +2*/
                countOfFactors += 2;
            }
            divisor++;
        }

        /** 스스로 제곱해서 만들어지는 숫자는 대칭되는 수가 없어서 +1
         *  예를 들면, 9의 약수 중 3
         * */
        if(divisor * divisor == N){
            countOfFactors++;
        }

        return countOfFactors;
    }

    public static void main(String[] args) {
        CountingFactors countingFactors = new CountingFactors();
        int N = Integer.MAX_VALUE;
        System.out.println(countingFactors.solution(N));
    }
}
