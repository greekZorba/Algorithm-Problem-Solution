package hackerRank.interviewPreparation.search;

public class IceCreamParlor {

    static void whatFlavors(int[] cost, int money) {

        boolean found = false;
        int firstId;
        for(int i=0; i<cost.length-1; i++) {
            firstId = i+1;
            int secondId = 0;
            for(int j=i+1; j<cost.length; j++) {
                secondId = j+1;

                if(money == cost[i] + cost[j]) {
                    found = true;
                    break;
                }

            }

            if(found) {
                System.out.println(firstId + " " + secondId);
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] cost = new int[]{2,2,4,3};
        int money = 4;
        IceCreamParlor.whatFlavors(cost, money);
    }

}
