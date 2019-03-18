package hackerRank;

public class BetweenTwoSets {

    /*
     * a 배열의 최소공배수와 b 배열의 최대공약수를 구하고
     * a배열의 최소공배수의 배수가 b 배열의 최대공약수까지 구하면
     * 조건에 만족하는 수를 찾을 수 있다.
     */
    static int getTotalX(int[] a, int[] b) {
        int lcmOfArray = lcm(a);
        int gcdOfArray = gcd(b);

        int index = 1;
        int total = 0;
        for(int i = lcmOfArray; i <= gcdOfArray; i=lcmOfArray*index){

            if(gcdOfArray % i == 0) {
                total++;
            }
            index++;
        }

        return total;
    }

    static int lcm(int[] a) {
        int leastCommonMultiple = a[0];
        for(int i=1; i<a.length; i++){
            leastCommonMultiple = lcm(leastCommonMultiple, a[i]);
        }

        return leastCommonMultiple;
    }

    static int lcm(int a, int b) {
        return a * b / (gcd(a,b));
    }

    static int gcd(int[] b) {
        int greatestCommonDivisor = b[0];
        for(int i=1; i<b.length; i++){
            greatestCommonDivisor = gcd(greatestCommonDivisor, b[i]);
        }

        return greatestCommonDivisor;
    }

    static int gcd(int a, int b) {
        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);

        int temp =1;
        while(temp > 0) {
            temp = bigger%smaller;
            bigger = smaller;
            smaller = temp;

        }

        return bigger;
    }


    public static void main(String[] args){
        int[] a = new int[]{2, 4};
        int[] b = new int[]{16, 32, 96};
        System.out.println(BetweenTwoSets.getTotalX(a, b));
    }
}
