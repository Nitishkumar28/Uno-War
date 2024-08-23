/**
 * Project 2
 * SmallestCardAI class
 * Author : Nitish Kumar Yarlagadda
 */
public class SmallestCardAI extends AI{

    /**
     * This SmallestCardAI class represents an AI that plays the lowest-rank valid card in its hand.
     */

    /**
     * This method is responsible for returning the smallest-rank valid card in the hand which is part of the cardPile
     * @param hand -- it represents the hand of cards that the AI will pick.
     * @param cardPile -- it represents the current card pile on which the AI is playing
     * @return - Smallest rank valid card
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        Card smallestRankCard = null; // Initially assigning the smallest card to be null
        for (int i = 0; i < hand.getSize(); i++) {
            Card playingCard = hand.get(i);
            if (cardPile.canPlay(playingCard)) {
               // This condition checks whether the current card has a smaller rank than the current smallest card in the hand
                if (smallestRankCard == null || playingCard.getRankNum() < smallestRankCard.getRankNum() ) {
                    smallestRankCard = playingCard; // updating the smallestRankCard variable with the smallest rank card found
                }
            }
        }
        return smallestRankCard;
    }

    /**
     * This function is responsible to return the name of the SmallestCard AI
     * @return - it returns the AI message name
     */
    @Override
    public String toString() {
        return "Smallest Card AI";
    }
}
