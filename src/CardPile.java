/**
 * Project 2
 * CardPile class
 * Author : Nitish Kumar Yarlagadda
 */
public class CardPile {

    /**
     * The CardPile class represents a pile of playing cards
     */
    private Card topCard;
    private int size;

    /**
     * This constructor is responsible to create a new card pile with the given card as the initial top card.
     * @param topCard -- it represents the card that must be considered as the card which is at the top in the new card pile
     */
    public CardPile(Card topCard) {
        this.topCard = topCard;
        this.size = 1; // Initializing the size to 1 in order to indicate the initial top card
    }

    /**
     * This function is responsible to check if the input card is legal to play on the current stack using the given
     * specified conditions.
     * @param card -- it represents the card which must be checked according to the legal play moves
     * @return -- returns a boolean value which indicates if the input card made a legal move or not
     */
    public boolean canPlay(Card card) {
        if (card == null) {
            return false;
        }
        boolean isHigherOrSameRank = card.getRankNum() >= topCard.getRankNum(); // checking if the card has higher or same rank as the current top card
        boolean isSameSuit = card.getSuitName().equals(topCard.getSuitName()); // checking if the card has the same suit as the top card
        return isHigherOrSameRank || isSameSuit;
    }

    /**
     * This function is responsible to add another card to the card pile making it the new top card, it returns an error
     * message if the move made by the card is illegal.
     * @param card -- It represents the card which will be played on the top of the pile
     */
    public void play(Card card) {
        if (canPlay(card)) {
           topCard = card; // New top card
           size++;
        }
        else {
            System.out.println("Illegal move detected!");
        }
    }

    /**
     * This function is responsible to get the number of cards in the card pile.
     * @return -- returns the size ( integer - which is the number of cards in the card pile)
     */
    public int getNumCards() {
        return size;
    }

    /**
     * This function is responsible to get the current top card for the current card pile.
     * @return -- returns the top card which is present in the current card pile
     */
    public Card getTopCard() {
        return topCard;
    }
}
