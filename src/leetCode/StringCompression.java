package leetCode;

import java.util.ArrayList;
import java.util.List;

public class StringCompression {

    public int compress(char[] chars) {
        if(chars.length == 1) {
            return 1;
        }

        char comparingChar = chars[0];
        int dupChar = 1;
        List<Character> mutatingArray = new ArrayList<>();
        for(int i=1; i<chars.length; i++) {

            if(comparingChar != chars[i]) {
                compressStringLength(mutatingArray, comparingChar, dupChar);
                comparingChar = chars[i];
                dupChar = 1;

            } else {
                dupChar++;
            }

            if(i == chars.length-1) {
                compressStringLength(mutatingArray, comparingChar, dupChar);
            }
        }

        for(int i=0; i<mutatingArray.size(); i++) {
            chars[i] = mutatingArray.get(i);
        }

        return mutatingArray.size();
    }

    private void compressStringLength(List<Character> mutatingArray,
                                     char comparingChar,
                                     int duplicateChar) {

        mutatingArray.add(comparingChar);

        if(duplicateChar != 1) {
            char[] dupChars = String.valueOf(duplicateChar).toCharArray();
            for(char count : dupChars) {
                mutatingArray.add(count);
            }
        }

    }

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        System.out.println(stringCompression.compress(chars));
    }
}
