/**
 * Project 2
 * AI class
 * Author : Nitish Kumar Yarlagadda
 */
public class AI {

    /**
     *  This AI class represents a Java class which serves both as a Random AI, and the parent class for all other AIs.
     */

    /**
     * This method is responsible for returning the first valid card which is picked from the hand part of the cardPile
     * @param hand -- it represents the hand of cards that the AI will pick.
     * @param cardPile -- it represents the current card pile on which the AI is playing
     * @return - returns the valid chosen card or null if no valid card can be played
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        for (int i = 0; i < hand.getSize(); i++) {
            Card playingCard = hand.get(i);
            if (cardPile.canPlay(playingCard)) {
                return playingCard;
            }
        }
        return null; // returning null to indicate that no card can be played on this card pile
    }

    /**
     * This function is responsible to return the name of the AI
     * @return - it returns the AI message name
     */
    public String toString() {
        return "Random Card AI";
    }
}
