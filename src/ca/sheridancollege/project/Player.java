/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 *
 * @author rishabhbajaj, 2019
 */
public abstract class Player {

    public GroupOfCards groupOfCards;

    private int turn;

    private String playerID; //the unique ID for this player

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param groupOfCards
     * @param playerID
     */
    public Player(GroupOfCards groupOfCards, String playerID) {
        this.groupOfCards = groupOfCards;
        this.playerID = playerID;
    }

    public GroupOfCards getGroupOfCards() {
        return groupOfCards;
    }

    public void setGroupOfCards(GroupOfCards groupOfCards) {
        this.groupOfCards = groupOfCards;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    /**
     * @return the playerID
     */
    public String getPlayerID() {
        return playerID;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param givenID the playerID to set
     */
    public void setPlayerID(String givenID) {
        playerID = givenID;
    }

    /**
     * The method to be instantiated when you subclass the Player class with
     * your specific type of Player and filled in with logic to play your game.
     */
    public abstract void play();

}
