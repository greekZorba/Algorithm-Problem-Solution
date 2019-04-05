package hackerRank;

public class NewYearChaos {

    static void minimumBribes(int[] q) {

        // 2칸을 초과해서 넘을 순 없다.
        for(int i=0; i<q.length; i++) {
            if(q[i] - (i+1) > 2 ){
                System.out.println("Too chaotic");
                return;
            }
        }

        int output = 0;
        for(int i=0; i<q.length; i++) {

            for(int j=i; j<q.length-1; j++) {

                if(q[j] > q[j+1]){
                    swap(q, j, j+1);
                    output++;

                    for(int out: q){
                        System.out.print(" "+out);

                    }
                    System.out.println();
                }



            }
        }

        System.out.println(output);

    }

    private static void swap(int[] input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        int[] q = new int[]{1, 2, 5, 3, 4, 7, 8, 6};
//        int[] q = new int[]{2,1,5,3,4};
        NewYearChaos.minimumBribes(q);

    }
}
