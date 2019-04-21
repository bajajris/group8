package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private final int TOTALCARDS = 52;
    private ArrayList<Card> cards;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Deck() {
        // TODO - implement Deck.Deck
    }

    public void shuffle() {
        // TODO - implement Deck.shuffle
        Collections.shuffle(cards);
    }

}
