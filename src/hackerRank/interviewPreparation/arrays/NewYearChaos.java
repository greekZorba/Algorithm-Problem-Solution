package hackerRank.interviewPreparation.arrays;

/**
 *
 * 배열의 맨 끝자리 인덱스부터 앞의 인덱스로만 swap 해줄 수 있다.
 * 그것도 최대 2번까지만 swap 가능
 * */
public class NewYearChaos {

    static void minimumBribes(int[] q) {

        int output = 0;
        for(int i=q.length-1; i>=0; i--) {

            // 뒤에서 오는 큰 수들이 2칸을 초과해서 넘을 순 없다.
            if(q[i] - (i+1) > 2 ){
                System.out.println("Too chaotic");
                return;
            }

            // 2칸 밖에 이동하지 못하기 때문에 2칸 전부터 큰 숫자가 있는지 확인한 뒤 swap할 횟수를 더해주면 됨
            // swap할 횟수만 구하면 되기 때문에 실제로 swap할 필요는 없다.
            for(int j = Math.max(0, q[i]-2); j < i; j++) {

                if(q[j] > q[i]) {
                    output++;
                }
            }
        }

        System.out.println(output);

    }

    public static void main(String[] args) {
        int[] q = new int[]{1, 2, 5, 3, 4, 7, 8, 6};
//        int[] q = new int[]{2,1,5,3,4};
        NewYearChaos.minimumBribes(q);

    }
}
