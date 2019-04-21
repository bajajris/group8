package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author rishabhbajaj
 */
public class MainCard {

    private static final Random rgen = new Random();
    static Scanner in = new Scanner(System.in);
    static int players;
    static ArrayList<GroupOfCards> groupOfCards = new ArrayList<>();
    static ArrayList<Card> cardDeck = new ArrayList<>();
    static ArrayList<Card> card = new ArrayList<>();

    public static void main(String[] args) {

        // extends game
        GoFish goFish = new GoFish("GO FISH");
        ArrayList<Player> player = new ArrayList<>();
        System.out.println("Enter total No. of players:");
        
        //check if inputted string is number
        if (checkStringInput(in.next()) == false) {
            System.out.println("Exit the program");
            System.exit(0);
        }

        // check if number of players inputted can work or not
        if (checkTotalPlayers(players) == false) {
            System.out.println("Exit the program");
            System.exit(0);
        }
        // make groups of card appropriate
        int groups = in.nextInt();
        if (checkGroupOfCards(groups) == false) {
            System.out.println("Exit the program");
            System.exit(0);
        }

        // create a card deck by randomly generating values and suits and adding it to card arrayList
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < 52/*groups*/; j++) {
                cardDeck.add(selectCardFromDeckRandomly());
                for (int k = 0; k < j; k++) {
                    if (cardDeck.get(j).toString().equalsIgnoreCase(cardDeck.get(k).toString())) {
                        cardDeck.remove(j);
                        j--;
                        break;
                    }
                }
            }
        }

        // set deck of cards
        Deck deck = new Deck();
        deck.setCards(cardDeck);
        for (int j = 0; j < players; j++) {

            for (int i = 0; i < groups; i++) {
                card.add(cardDeck.get(i));
                // add different cards toanother group of cards
            }
            //sets car arrayList to group of cards
            groupOfCards.add(new GroupOfCards(groups, card));
            System.out.println("Enter Player " + (j + 1) + " ID:");
            player.add(new Player(groupOfCards.get(j), in.next()) {
                int k = 1;

                @Override
                public void play() {
                    setTurn(k++);
                    // set player turn number
                }
            });
        }

        for (int i = 0; i < players; i++) {
            System.out.println(i + 1 + "   player");
            for (int j = 0; j < groups; j++) {
                System.out.println(groupOfCards.get(i).toString());
            }
        }

        //play game and check if there is a winner after each round
        for (int i = 0; i < players; i++) {
            while (player.get(i).getGroupOfCards().getSize() != 0) {
                // logic to play code
            }

            if (checkGameOver(player.get(i).getGroupOfCards().getSize()) == true) {
                goFish.declareWinner();
            } else if (i == players - 1) {
                i = 0;
            }
        }

    }

    //check valid number of players
    public static boolean checkTotalPlayers(int players) {
        return players <= 7 && players >= 2;
    }
    //check valid number of group of cards
    public static boolean checkGroupOfCards(int groups) {
        return groups >= 5 && groups <= 7;
    }
        //check if game is over or not
    public static boolean checkGameOver(int size) {
        return size <= 0;
    }

    //get random cards
    public static Card selectCardFromDeckRandomly() {
        Card.Value rank = selectRandomCardRank();
        Card.Suit suit = selectRandomCardSuit();
        return (new Card(suit, rank));
    }

    //get value/rank
    private static Card.Value selectRandomCardRank() {
        Card.Value cardRank;
        int r = 1 + rgen.nextInt(13);
        switch (r) {
            case 1:
                cardRank = Card.Value.ACE;
                break;
            case 2:
                cardRank = Card.Value.TWO;
                break;
            case 3:
                cardRank = Card.Value.THREE;
                break;
            case 4:
                cardRank = Card.Value.FOUR;
                break;
            case 5:
                cardRank = Card.Value.FIVE;
                break;
            case 6:
                cardRank = Card.Value.SIX;
                break;
            case 7:
                cardRank = Card.Value.SEVEN;
                break;
            case 8:
                cardRank = Card.Value.EIGHT;
                break;
            case 9:
                cardRank = Card.Value.NINE;
                break;
            case 10:
                cardRank = Card.Value.TEN;
                break;
            case 11:
                cardRank = Card.Value.JACK;
                break;
            case 12:
                cardRank = Card.Value.QUEEN;
                break;
            default:
                cardRank = Card.Value.KING;
                break;
        }
        return cardRank;
    }

    /**
     * Randomly select a card suit
     *
     * @return The selected card suit
     */
    private static Card.Suit selectRandomCardSuit() {
        Card.Suit cardSuit;
        int s = 1 + rgen.nextInt(4);
        switch (s) {
            case 1:
                cardSuit = Card.Suit.CLUBS;
                break;
            case 2:
                cardSuit = Card.Suit.DIAMONDS;
                break;
            case 3:
                cardSuit = Card.Suit.HEARTS;
                break;
            default:
                cardSuit = Card.Suit.SPADES;
                break;
        }
        return cardSuit;
    }

    //check if inputted val is string
    public static boolean checkStringInput(String p) {
        try {
            players = Integer.parseInt(p);
            return true;

        } catch (NumberFormatException e) {

            return false;
        }
    }
}
