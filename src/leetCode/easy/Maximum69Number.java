package leetCode.easy;

public class Maximum69Number {

    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder();

        String stringNum = String.valueOf(num);
        int stringNumLength = stringNum.length();
        boolean isChangedNum = false;

        for(int i=0; i<stringNumLength; i++) {
            int oneNum = Character.getNumericValue(stringNum.charAt(i));

            if(!isChangedNum && oneNum == 6) {
                sb.append(9);
                isChangedNum = true;
            } else {
                sb.append(oneNum);
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        Maximum69Number maximum69Number = new Maximum69Number();
        System.out.println(maximum69Number.maximum69Number(9999));
    }
}
