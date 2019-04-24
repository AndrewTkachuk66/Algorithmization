package game_21;
/* чирва, бубна, трефа, піка */
enum SUITS {Heart, Diamond, Club, Spade};
enum RANKS {
    Ace(11), King(4), Queen(3), Jack(2), Ten(10), Nine(9), Eight(8), Seven(7), Six(6);

    private final int point;

    RANKS(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }
}

    public class Card {
        private SUITS suit;
        private RANKS rank;

        public Card(int newSuit, int newRank) {
            switch (newSuit) {
                case 0 : suit = SUITS.Heart; break;
                case 1 : suit = SUITS.Diamond; break;
                case 2 : suit = SUITS.Club; break;
                case 3 : suit = SUITS.Spade; break;
                default : suit = null; System.out.println("empty pack!");
            }
            switch (newRank) {
                case 0 : rank = RANKS.Ace; break;
                case 1 : rank = RANKS.King; break;
                case 2 : rank = RANKS.Queen; break;
                case 3 : rank = RANKS.Jack; break;
                case 4 : rank = RANKS.Six; break;
                case 5 : rank = RANKS.Seven; break;
                case 6 : rank = RANKS.Eight; break;
                case 7 : rank = RANKS.Nine; break;
                case 8 : rank = RANKS.Ten; break;
                default : rank = null; System.out.println("empty pack!");
            }
        }
        public String getNameOfCard() {
            return "Suit-" + suit + " Rank-" + rank + ";\n";
        }
        public int getValueOfCard() {
            return rank.getPoint();
        }
    }


