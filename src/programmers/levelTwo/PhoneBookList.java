package programmers.levelTwo;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 전화번호 목록
 * */
public class PhoneBookList {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> phoneMap = new HashMap<>();
        for(int i=0; i<phone_book.length; i++){
            phoneMap.put(phone_book[i], Integer.parseInt(phone_book[i]));
        }

        

        for(int i=0; i<phone_book.length-1; i++){

            for(int j=1; j<phone_book.length; j++){
//                String temp = phone_book[j].substring(0, phone_book[i].length());
//                String temp = phone_book[j].substring(0, 3);
                System.out.println("____"+"1234".substring(0,3));
                System.out.println("__length"+phone_book[i].length());
                if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PhoneBookList phoneBookList = new PhoneBookList();
//        String[] phone_book = new String[]{"123","456","789"};
//        String[] phone_book = new String[]{"119", "97674223", "1195524421"};
        String[] phone_book = new String[]{"12","123","1235","567","88"};
        System.out.println(phoneBookList.solution(phone_book));
    }
}
