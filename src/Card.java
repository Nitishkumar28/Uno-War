/**
 * Project 2
 * Card class
 * Author : Nitish Kumar Yarlagadda
 */

public class Card {

    /**
     * This card class represents a single playing card
     */
    private final int rank;
    private final int suit;
    private final String[] ranksName = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    private final String[] suitsName = {"Spades","Hearts","Clubs","Diamonds"};

    /**
     * This constructor holds two parameters which are rank and suit, and it is responsible for setting the private variables
     * and validating the inputs where if an incorrect rank or suit is given then it prints an error message along with
     * setting the private variables to be ace of spades (rank = 1, suit = 1).
     * @param rank -- rank represents the number on the card
     * @param suit -- suit represents the type of suit
     */
    public Card(int rank, int suit) {
        if (rank < 1 || rank > 13 || suit < 1 || suit > 4) {
            System.out.println("Invalid Card");
            this.rank = 1; // returning rank as 1 because invalid card must be set to Ace
            this.suit = 1; // returning suit as 1 because invalid card must be set to spades
        } else {
            this.rank = rank;
            this.suit = suit;
        }
    }

    /**
     * This method is responsible to return the number representation of the cards rank.
     * @return - returns an integer which represents the number of the cards rank
     */
    public int getRankNum(){
        return this.rank; // returns the number representation of the cards rank
    }

    /**
     * This method is responsible to return the string naming the cards rank.
     * @return - String which indicates the name of the cards rank
     */
    public String getRankName(){
        // The index is written with a -1 as arrays are indexed from 0 and the input starts from 1 , hence to convert and retrieve the previous index number
        return ranksName[getRankNum()-1]; // returns the string naming the cards rank
    }

    /**
     * This method is responsible to return the string naming the cards suit.
     * @return - String which indicates the name of the cards suit
     */
    public String getSuitName(){
        // The index is written with a -1 as arrays are indexed from 0 and the input starts from 1 , hence to convert and retrieve the previous index number
        return suitsName[this.suit-1]; // returns the string naming the cards suit
    }

    /**
     * This method is responsible for the representation of the string in the format of rank name followed by the word 'of'
     * and the suit name.
     * @return - string of the card object
     */
    public String toString(){
        return getRankName() + " of " + getSuitName();
    }

    /**
     * This method is responsible to check if the objects are equal or not by comparing the rank and suit of the card.
     * @param obj -- It represents the object that will be compared
     * @return - Boolean value indicating if the objects are same or not
     */
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        else if (obj == null){
            return false;
        }
        else if (obj instanceof Card){
            Card other = (Card) obj;
            return this.rank == other.rank && this.suit == other.suit;
        }
        else {
            return false;
        }
    }
}
