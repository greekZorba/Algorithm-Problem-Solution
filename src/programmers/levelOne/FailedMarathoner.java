package programmers.levelOne;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap 문제
 * 완주하지 못한 선수
 * */
public class FailedMarathoner {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> participantMap = new HashMap<>();
        for(int i=0; i<participant.length; i++){

            if(participantMap.containsKey(participant[i])){
                participantMap.put(participant[i], participantMap.get(participant[i])+1);

            }else{
                participantMap.put(participant[i], 1);
            }

        }

        for(int i=0; i<completion.length; i++){
            participantMap.put(completion[i], participantMap.get(completion[i])-1);
        }

        for(String failedMarathoner : participantMap.keySet()){

            if(participantMap.get(failedMarathoner) == 1){
                answer = failedMarathoner;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        FailedMarathoner failedMarathoner = new FailedMarathoner();
        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"mislav", "stanko", "ana"};

        System.out.println(failedMarathoner.solution(participant, completion));
    }
}
