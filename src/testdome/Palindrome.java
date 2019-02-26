package testdome;

public class Palindrome {

    public static boolean isPalindrome(String word) {
        if(word.length()<=1){
            return true;
        }
        String reverseWord = "";
        for(int i=word.length()-1; i>=0; i--){
            reverseWord += String.valueOf(word.charAt(i));
        }

        if(reverseWord.toLowerCase().equals(word.toLowerCase())){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("ABCBA"));
    }
}