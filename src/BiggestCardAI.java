/**
 * Project 2
 * BiggestCardAI class
 * Author : Nitish Kumar Yarlagadda
 */
public class BiggestCardAI extends AI {

    /**
     * This BiggestCardAI represents an AI that plays the highest-rank valid card in its hand.
     */

    /**
     * This method is responsible for returning the biggest-rank valid card in the hand which is part of the cardPile.
     * @param hand -- it represents the hand of cards that the AI will pick.
     * @param cardPile -- it represents the current card pile on which the AI is playing
     * @return - Biggest rank valid card
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        Card biggestRankCard = null; // Initially assigning the biggest card to be null
        for (int i = 0; i < hand.getSize(); i++) {
            Card playingCard = hand.get(i);
            if (cardPile.canPlay(playingCard)) {
                // This condition checks whether the current card has a greater rank than the current biggest card in the hand
                if (biggestRankCard == null || playingCard.getRankNum() > biggestRankCard.getRankNum()) {
                    biggestRankCard = playingCard; // updating the biggestRankCard variable with the biggest rank card found
                }
            }
        }
        return biggestRankCard;
    }

    /**
     * This function is responsible to return the name of the BiggestCard AI.
     * @return - it returns the AI message name
     */
    @Override
    public String toString() {
        return "Biggest Card AI";
    }
}
