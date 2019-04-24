package game_21;

import java.util.ArrayList;
import java.util.Random;

public class Pack {
    private ArrayList<Card> pack = new ArrayList<Card>(36);

    public Pack() {
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 8; j++) {
                pack.add(new Card(i, j));
            }
        }
    }

    public Card getCardFromPack() {
        Random random = new Random();
        Card randomCard = pack.get(random.nextInt(pack.size()));
        pack.remove(randomCard);
        return randomCard;
    }
}

