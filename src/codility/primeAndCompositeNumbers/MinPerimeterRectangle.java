package codility.primeAndCompositeNumbers;

public class MinPerimeterRectangle {

    public int solution(int N) {

        if(N == 1){
            return 4;
        }

        long divisor = 1;
        int min = Integer.MAX_VALUE;
        while(divisor * divisor < N){

            if(N % divisor == 0 && min > (int)divisor + (N/(int)divisor)){
                min = 2 *((int)divisor + (N/(int)divisor));
            }
            divisor += 1;
        }

        if(divisor * divisor == N){
            min = 2 * ((int)divisor+(int)divisor);
        }

        return min;
    }

    public static void main(String[] args) {
        MinPerimeterRectangle minPerimeterRectangle = new MinPerimeterRectangle();
        int N = 1000000000;
        System.out.println(minPerimeterRectangle.solution(N));
    }
}
