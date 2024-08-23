/**
 * Project 2
 * UnoWarMatch class
 * Author : Nitish Kumar Yarlagadda
 */
public class UnoWarMatch {

    /**
     * This UnoWarMatch class represents a match-up of two AIs at UnoWar
     */
    private final AI ai1;
    private final AI ai2;

    /**
     * This constructor is responsible to take two AIs which the UnoWarMatch is intended to compare, sets the values to
     * the private variables.
     * @param ai1 -- This represents the first AI which will compete in the match
     * @param ai2 -- This represents the second AI which will compete in the match
     */
    public UnoWarMatch(AI ai1, AI ai2) {
        this.ai1 = ai1;
        this.ai2 = ai2;
    }

    /**
     * This method represents a single game of UnoWar which is played with two AIs and returns true if the first AI wins
     * and false if second AI wins.
     * @return - Boolean value indicating which AI won the match
     */
    public boolean playGame() {
        int pointsScoreByAI1 = 0; // Initializing 0 as the point scores by first AI
        int pointsScoreByAI2 = 0; // Initializing 0 as the point scores by second AI
        boolean AITurn = true; // Boolean value to indicate which AI turn it is to play
        int totalPoints=10; // Initializing the total round points to win as 10 according to game rules
        // The game continues till an AI player has reached 10 points
        while (pointsScoreByAI1 < totalPoints  && pointsScoreByAI2 < totalPoints) {
            Deck deck = new Deck(); // A new deck is created
            deck.shuffle();
            Hand firstHand = new Hand(deck, 5);
            Hand secondHand = new Hand(deck, 5);
            CardPile cardPile = new CardPile(deck.draw());

            boolean completedRound = false; // Initially setting the completed round to be false
            // completed round indicates if the current game round is finished or not
            while (!completedRound) {
                if (AITurn) {
                    Card playingCard = ai1.getPlay(firstHand, cardPile); // First AI selects a card to play
                    if (playingCard == null) {
                        completedRound = true; // If the AI cannot play with a valid card then the flag variable is made true to indicate that the round is over
                        pointsScoreByAI2++; // Second AI gets the point if the round is finished
                    } else {
                        cardPile.play(playingCard); // If the first AI can play a valid card then the card is played
                        firstHand.remove(playingCard); // It is then removed from the hand
                    }
                } else {
                    Card cardToPlay = ai2.getPlay(secondHand, cardPile); // Second AI selects a card to play
                    if (cardToPlay == null) {
                        completedRound = true; // If the AI cannot play with a valid card then the flag variable is made true to indicate that the round is over
                        pointsScoreByAI1++; // First AI gets the point if the round is finished
                    } else {
                        cardPile.play(cardToPlay); // If the second AI can play a valid card then the card is played, and it is removed from the hand
                        secondHand.remove(cardToPlay); // It is then removed from the hand
                    }
                }
                 AITurn = !AITurn; // Switching the turn for the next AI to play
            }
        }
        return pointsScoreByAI1 >= 10; // returning true if the score of first AI is greater than or equal to 10 indicating its win
    }

    /**
     * This method is responsible to make the AIs play each other nTrial times and report the percent of times AI 1
     * beat AI2 as a double.
     * @param nTrials -- It represents the number of times the match is played between the two AIs
     * @return - returns a double value between 0 and 1 inclusive ( percent win rate)
     */
    public double winRate(int nTrials) {
        int Ai1WinCount = 0;
        for (int i = 0; i < nTrials; i++) {
            if (playGame()) {
                Ai1WinCount++;
            }
        }
        return (double) Ai1WinCount / nTrials;
    }
}
