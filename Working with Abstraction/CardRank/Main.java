package CardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        for (CardRank rank : CardRank.values()) {
            System.out.println("Ordinal value: " + rank.ordinal() + "; Name value: " + rank.name());
        }
    }
}
