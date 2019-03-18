package hackerRank;

public class BetweenTwoSets {

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        System.out.println("최대 공약수 :" +gcd(b));
        System.out.println("최소공배수 : "+lcm(a));

        return 0;
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
        System.out.println("???"+ greatestCommonDivisor);
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
        System.out.println("sssss : "+a + " "+ b);
        return smaller;
    }


    public static void main(String[] args){
        int[] a = new int[]{2, 6};
        int[] b = new int[]{24, 36};
        System.out.println(BetweenTwoSets.getTotalX(a, b));
    }
}
