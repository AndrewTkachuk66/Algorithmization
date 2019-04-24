package game_21;

import java.util.ArrayList;
import java.util.Comparator;

public class Player {
    private int playerID;
    private int point;
    private static Pack pack = new Pack();
    private ArrayList<Card> dealOfcard = new ArrayList<Card>();

    Player(int id) {
        this.playerID = id;

    }

    @Override
    public String toString() {
        return "Player " + playerID;
    }

    public void getOneMoreCard() {
        dealOfcard.add(pack.getCardFromPack());
    }

    public int getPointSumm() {
        int summ = 0;
        for (Card i : dealOfcard) {
            summ += i.getValueOfCard();
        }
        point = summ;
        return summ;
    }
    public String showCards() {
        String result = "";
        int value = 0;
        for (Card i : dealOfcard) {
            result += i.getNameOfCard();
            value += i.getValueOfCard();
        }
        return "You have cards  : " + "\n" + result + "in total you scored " + value + " points";

    }
    public static Comparator<Player> pointComparator = new Comparator<Player>() {
        //@Override
        public int compare(Player o1, Player o2) {
            return o2.point - o1.point;
        }
    };

}
