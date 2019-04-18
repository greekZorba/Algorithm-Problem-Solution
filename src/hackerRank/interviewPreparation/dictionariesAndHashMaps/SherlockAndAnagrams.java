package hackerRank.interviewPreparation.dictionariesAndHashMaps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s) {


        int result = 0;

        for(int i=0; i<s.length(); i++) {
            int stringLength = 1;

            for(int j=0; j<s.length(); j++) {
                LinkedList<String> charCollection = new LinkedList<>();

                if(i+stringLength > s.length()){
                    break;
                }

                // 기준이 될 알파벳 넣기
                for(int k=i; k<i+stringLength; k++) {
                    charCollection.add(String.valueOf(s.charAt(k)));
                }

                System.out.println(charCollection.toString());
                for(int k=j; k<s.length(); k++) {

                    boolean pairFlag = true;
                    LinkedList<String> dummyCollection = charCollection;

                    for(int l=k; l<k+stringLength; l++) {

                        if(dummyCollection.contains(String.valueOf(s.charAt(k)))){

                            dummyCollection.remove(String.valueOf(s.charAt(k)));
                        }else{
                            pairFlag = false;
                            break;
                        }

                    }

                    if(pairFlag){

                        result++;
                    }
                }

                stringLength++;
            }

        }


        return result;
    }


    public static void main(String[] args) {

        System.out.println(SherlockAndAnagrams.sherlockAndAnagrams("abcd"));
    }
}
