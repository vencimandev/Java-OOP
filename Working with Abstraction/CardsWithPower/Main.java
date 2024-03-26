package CardsWithPower;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String rankInput = sc.nextLine().toUpperCase();
        String suitInput = sc.nextLine().toUpperCase();;

        Rank rank = Rank.valueOf(rankInput);
        Suit suit = Suit.valueOf(suitInput);
        Suit.Card card = new Suit.Card(rank, suit);

        System.out.println(card);
    }
}
