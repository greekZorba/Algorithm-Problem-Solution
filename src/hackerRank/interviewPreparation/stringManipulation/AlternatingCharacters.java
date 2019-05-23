package hackerRank.interviewPreparation.stringManipulation;

public class AlternatingCharacters {

    static int alternatingCharacters(String s) {

        if(s.length() < 2) {
            return 0;
        }

        int count = 0;
        for(int i=1; i<s.length(); i++) {

            if(s.charAt(i) == s.charAt(i-1)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "AAAA";
        System.out.println(AlternatingCharacters.alternatingCharacters(s));
    }
}
