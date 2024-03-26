package CardsWithPower;

enum Suit {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private final int power;

    Suit(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }
    static class Card {
        private final Rank rank;
        private final Suit suit;
        private final int power;

        public Card(Rank rank, Suit suit) {
            this.rank = rank;
            this.suit = suit;
            this.power = rank.getPower() + suit.getPower();
        }

        @Override
        public String toString() {
            return String.format("Card name: %s of %s; Card power: %d", rank, suit, power);
        }
    }
}