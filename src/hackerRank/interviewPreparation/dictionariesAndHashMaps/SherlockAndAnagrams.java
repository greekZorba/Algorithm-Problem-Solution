package hackerRank.interviewPreparation.dictionariesAndHashMaps;

import java.util.LinkedList;

public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s) {

        int result = 0;

        for(int i=0; i<s.length()-1; i++) {
            int stringLength = 1;

            for(int j=i; j<s.length()-1; j++) {

                LinkedList<String> perCharacter = new LinkedList<>();

                // 비교할 기준이 될 문자 만듦
                for(int k=i; k<i+stringLength; k++){
                    perCharacter.add(String.valueOf(s.charAt(k)));
                }

                for(int k=i+1; k<s.length(); k++){
                    boolean matchFlag = true;
                    LinkedList<String> dummyCharacter = new LinkedList<>();

                    // 체크할 문자길이가 실제 문자길이보다 길어지면 break
                    if(k+stringLength > s.length()){
                        break;
                    }

                    // 깊은 복사를 위해서 직접 for문 돌림
                    // 비교하려는 문자열을 원상태로 되돌려 비교하기 위해
                    for(int l=0; l<perCharacter.size(); l++) {
                        dummyCharacter.add(perCharacter.get(l));
                    }

                    // 기준되는 문자열과 만들어지는 문자열들을 비교
                    for(int l=k; l<k+stringLength; l++) {
                        String comparingChar = String.valueOf(s.charAt(l));

                        // 알파벳 순서가 달라도 존재만 하면 되기 때문에
                        // 존재 유무를 체크해서 remove
                        if(dummyCharacter.contains(comparingChar)) {

                            dummyCharacter.remove(comparingChar);
                        }
                        // 존재하지 않는 틀린 문자가 나오면 더이상 비교가 필요없이 Anagram에서 탈락
                        else {
                            matchFlag = false;
                            break;
                        }
                    }

                    if(matchFlag){
                        result++;
                    }

                }
                stringLength++;

            }

        }

        return result;
    }


    public static void main(String[] args) {

        System.out.println(SherlockAndAnagrams.sherlockAndAnagrams("mom"));
    }
}
