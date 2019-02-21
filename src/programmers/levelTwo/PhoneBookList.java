package programmers.levelTwo;


import java.util.Arrays;

/**
 * 전화번호 목록
 * */
public class PhoneBookList {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length-1; i++){

            for(int j=i+1; j<phone_book.length; j++){

                if(phone_book[i].charAt(0) != phone_book[j].charAt(0)){
                    break;
                }

                String longerPhoneNum = phone_book[i].length() >= phone_book[j].length() ? phone_book[i] : phone_book[j];
                String shorterPhoneNum = phone_book[i].length() < phone_book[j].length() ? phone_book[i] : phone_book[j];

                if(shorterPhoneNum.equals(longerPhoneNum.substring(0, shorterPhoneNum.length()))){
                        answer = false;
                        break;
                }
            }

            if(!answer){
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PhoneBookList phoneBookList = new PhoneBookList();
//        String[] phone_book = new String[]{"123","456","789"};
//        String[] phone_book = new String[]{"119", "97674223", "1195524421"};
        String[] phone_book = new String[]{"12","123","1235","567","88"};
//        String[] phone_book = new String[]{"113", "12340", "123440", "12345", "98346"};
        System.out.println(phoneBookList.solution(phone_book));
    }
}
