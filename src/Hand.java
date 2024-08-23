/**
 * Project 2
 * Hand class
 * Author : Nitish Kumar Yarlagadda
 */
public class Hand {

    /**
     * The hand class represents a hand of playing cards
     */
    private Card[] hands;
    private final Deck deck;
    private final int size;

    /**
     * This constructor creates an array to store the cards of the given size, and then draws it from the full of cards
     * using the supplied deck.
     * @param deck -- it represents a deck of cards
     * @param size -- it represents the size of the array to store the cards
     */
    public Hand(Deck deck, int size) {
        this.deck = deck;
        this.size = size;
        this.hands = new Card[size]; // Creating a hands array of the given size
        for (int i = 0; i < size; i++) {
            hands[i] = deck.draw(); // drawing a card and assigning it to the hands array at index i
        }
    }

    /**
     * This function is responsible to return the size of the hand.
     * @return - returns the size (integer)
     */
    public int getSize() {
        return this.size;
    }

    /**
     * This function is responsible to get the card at the given index in a hand, it returns an error message if the
     * size is out of bounds.
     * @param i -- it represents the index at which card has to be drawn
     * @return - returns the card at the specified index
     */
    public Card get(int i) {
        if (i < 0 || i >= size) {
            System.out.println("Invalid hand index!");
            return hands[0]; // returning the first card as the index is out of bounds
        }
        return hands[i]; // returning the card at the given index
    }

    /**
     * This function is responsible to remove a given card from the hand, such that if the card is found then a replacement
     * card should be drawn from the deck and return a boolean value indicating the operation.
     * @param card -- it represents the card to be removed
     * @return - returns boolean value indicating the specified card is removed or not
     */
    public boolean remove(Card card) {
        if (card == null) {
            return false; // returning false as the input card is null
        }
        for (int i = 0; i < size; i++) {
            if (hands[i].equals(card)) {
                hands[i] = deck.draw();
                return true;
            }
        }
        return false; // returning false as the card is not found in the hand
    }

}
