package testdome;

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        boolean findEqual = false;
        int[] returnIndex = new int[2];

        for(int i=0; i<list.length-1; i++){

            for(int j=list.length-1; j>0; j--){

                if(list[i] + list[j] == sum){
                    findEqual = true;
                    returnIndex[0] = i;
                    returnIndex[1] = j;
                    break;
                }
            }

            if(findEqual){
                break;
            }
        }

        if(findEqual){
            return returnIndex;
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
