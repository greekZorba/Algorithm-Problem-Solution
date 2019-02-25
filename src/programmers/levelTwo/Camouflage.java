package programmers.levelTwo;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap 문제
 * 위장
 *
 * */
public class Camouflage {

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> clotheList = new HashMap<>();
        for(int i=0; i<clothes.length; i++){

            if(clotheList.containsKey(clothes[i][1])){
                clotheList.put(clothes[i][1], clotheList.get(clothes[i][1]) + 1);

            }else{
                clotheList.put(clothes[i][1], 1);
            }

        }

        /**
         * 각각의 옷을 안 입었을 경우를 포함해서 +1을 해서 모든 경우의 수를 곱한다.
         * face: crow_mask, blue_sunglasses, 0(아무것도 안쓰는 경우)
         * */
        for(String key : clotheList.keySet()){
            answer *= clotheList.get(key)+1;
        }

        /** 아무것도 입는 경우는 없으므로 -1 */
        answer -= 1;
        return answer;
    }

    public static void main(String[] args) {
        Camouflage camouflage = new Camouflage();
        String[][] clothes = new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(camouflage.solution(clothes));

    }
}
