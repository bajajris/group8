package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author rishabhbajaj
 */
public class MainCard {

    private static Random rgen = new Random();
    static Scanner in = new Scanner(System.in);
    static int players;
    static ArrayList<GroupOfCards> groupOfCards = new ArrayList<>();
    static ArrayList<Card> cardDeck = new ArrayList<>();
    static ArrayList<Card> card = new ArrayList<>();

    public static void main(String[] args) {

        Game game = new Game("GO FISH") {
            @Override
            public void play() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void declareWinner() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        ArrayList<Player> player = new ArrayList<>();
        System.out.println("Enter total No. of players:");
        players = in.nextInt();
        checkTotalPlayers(players);
        if (checkTotalPlayers(players) == false) {
            System.out.println("Exit the program");
            System.exit(0);
        }
//        game.setPlayers(player);
        int groups = in.nextInt();
        if (checkGroupOfCards(groups) == false) {
            System.out.println("Exit the program");
            System.exit(0);
        }

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

        Deck deck = new Deck();
        deck.setCards(cardDeck);
        int groupDifference = 0;
        for (int j = 0; j < players; j++) {

            for (int i = 0; i < groups; i++) {
                card.add(cardDeck.get(i));
                cardDeck.remove(i);
            }
            groupOfCards.add(new GroupOfCards(groups, card));
            System.out.println("Enter Player " + (j + 1) + " ID:");
            player.add(new Player(groupOfCards.get(j), in.next()) {
                int k = 1;

                @Override
                public void play() {
                    setTurn(k++);
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            System.out.println(groupOfCards.get(0).toString());
//            card.clear();
            groupDifference += groups;
            System.out.println(groupOfCards.get(0).toString());
        }
        
        for (int i = 0; i < players; i++) {
            System.out.println(i + 1 + "   player");
            for (int j = 0; j < groups; j++) {
                System.out.println(groupOfCards.get(i).toString());
            }
        }

        for (int i = 0; i < players; i++) {
            while (player.get(i).getGroupOfCards().getSize() != 0) {
                // logic to play code
            }

            if (player.get(i).getGroupOfCards().getSize() == 0) {
                game.declareWinner();
            } else if (i == players - 1) {
                i = 0;
            }
        }

    }

    public static boolean checkTotalPlayers(int players) {
        return players <= 7 && players >= 2;
    }

    public static boolean checkGroupOfCards(int groups) {
        return groups >= 5 && groups <= 7;
    }

    public static boolean checkGameOver(int size) {
        return size <= 0;
    }

    public static Card selectCardFromDeckRandomly() {
        Card.Value rank = selectRandomCardRank();
        Card.Suit suit = selectRandomCardSuit();
        return (new Card(suit, rank));
    }

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

}
