import java.util.Random;
/**
 * Project 2
 * Deck class
 * Author : Nitish Kumar Yarlagadda
 */
public class Deck {
    /**
     * This deck class represents a deck of playing cards
     */
    private Card[] playingCards;
    private int nextCardIndex;
    private Random random;

    /**
     * This constructor is responsible to create a new deck by creating an array of 52 cards, along with using the
     * shuffle method in order to have decks shuffled by default.
     */
    public Deck() {
        playingCards = new Card[52];
        int entryIndex = 0;
        random = new Random();
        for (int suit = 1; suit < 5; suit++) {
            for (int rank = 1; rank < 14; rank++) {
                playingCards[entryIndex] = new Card(rank, suit); // creating a card for each combination possible
                entryIndex++;
            }
        }
        shuffle(); // shuffle is called in order to shuffle all decks by default
    }

    /**
     * This function is responsible for shuffling a deck of cards and this is done through the use of
     * Durstenfeld-Fisher-Yates1 algorithm which exchanges randomly chosen pairs of array elements.
     */
    public void shuffle() {
        for (int i = playingCards.length - 1; i > 0; i--) {
            int bound = i+1;
            int j = random.nextInt(bound);
            Card tempCard = playingCards[i];
            playingCards[i] = playingCards[j];
            playingCards[j] = tempCard;
        }
        nextCardIndex = 0; // resets the value to 0 in order to start drawing cards from the beginning in the shuffled deck
    }

    /**
     * This function is responsible to draw and return the next card such that the drawn card won't be repeated until
     * the deck is shuffled again.
     * @return - returns the next drawn card
     */
    public Card draw() {
        if (isEmpty()) {
            shuffle();
        }
        Card cardToBeDrawn = playingCards[nextCardIndex]; // Creating a new card and assigning it to the cardToBeDrawn at the current nextCardIndex.
        nextCardIndex++; // moving the index to the next card
        return cardToBeDrawn; // returning the drawn card
    }

    /**
     * This function is responsible for returning the number of cards remaining before the next reshuffle.
     * @return - returns the numbers of cards remaining
     */
    public int cardsRemaining() {
        return playingCards.length - nextCardIndex;
    }

    /**
     * This function is responsible to check whether the deck is empty or not.
     * @return - returns boolean value which states if the deck is empty or not
     */
    public boolean isEmpty() {
        // using >= in order to ensure that it returns true if the nextCardIndex ever exceeds the standard deck size
        return nextCardIndex >= playingCards.length;
    }
}
