package hackerRank.interviewPreparation.dictionariesAndHashMaps;

import java.util.HashMap;
import java.util.Map;

public class HashTables {

    static void checkMagazine(String[] magazine, String[] note) {

        Map<String, Integer> magazineMap = new HashMap<>();
        for(String input : magazine) {

            if(magazineMap.containsKey(input)){
                magazineMap.put(input, magazineMap.get(input)+1);
            }else {
                magazineMap.put(input, 1);
            }

        }

        for(String wordOfNote : note) {

            if(magazineMap.containsKey(wordOfNote)) {
                magazineMap.put(wordOfNote, magazineMap.get(wordOfNote)-1);

                if(magazineMap.get(wordOfNote) < 0) { // 중복으로 등록된 key
                    System.out.println("No");
                    return;
                }

            }

            if(!magazineMap.containsKey(wordOfNote)){
                System.out.println("No");
                return;
            }

        }

        System.out.println("Yes");

    }

    public static void main(String[] args) {
        String[] magazine = new String[]{"give", "me", "one", "grand", "today", "night"};
        String[] note = new String[]{"give", "one", "grand", "today"};
//        String[] magazine = new String[]{"two", "times", "three", "is", "not", "four"};
//        String[] note = new String[]{"two", "times", "two", "is", "four"};

        HashTables.checkMagazine(magazine, note);
    }
}
