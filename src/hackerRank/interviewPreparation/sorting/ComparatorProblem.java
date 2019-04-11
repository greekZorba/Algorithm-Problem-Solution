package hackerRank.interviewPreparation.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorProblem implements Comparator<Player> {

    @Override
    public int compare(Player a, Player b) {


        if(a.score() < b.score()){
            return 1;

        }else if(a.score() > b.score()){
            return -1;

        }else if(a.score() == b.score()){
            // compareToIgnoreCase는 대소문자를 분간하지 않고 문자열 비교
            return a.name().compareToIgnoreCase(b.name());
        }

        return 0;
    }

    public static void main(String[] args) {

        List<Player> playerList = Arrays.asList(
                new Player("Smith", 20),
                new Player("Jones", 15),
                new Player("Jones", 20)
        );
        Collections.sort(playerList, new ComparatorProblem());


        System.out.println(playerList.toString());

    }
}

class Player {

    private String name;

    private int score;

    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String name() {
        return this.name;
    }

    public int score() {
        return this.score;
    }

    public String toString(){
        return "name : "+ this.name + ", score : " + this.score;
    }

}


