/**
 * Project 2
 * Tournament class
 * This tournament class is the runnable program.
 * Author : Nitish Kumar Yarlagadda
 */
public class Tournament {
    /**
     * This tournament class is a driver class with a main method that reports the win-rate for every possible
     * pair of AIs.
     */
    public static void main(String[] args) {
        int nTrials = 1000;
        AI randomAI = new AI(); // Initializing a random AI object
        AI smallAI = new SmallestCardAI(); // Initializing a SmallestCardAI AI object
        AI bigAI = new BiggestCardAI(); // Initializing a BiggestCardAI AI object
        AI[] AICollectionArray = {randomAI, smallAI, bigAI}; // Storing the three AI in a new array

        for (AI ai1 : AICollectionArray) {
            for (AI ai2 : AICollectionArray) {
                UnoWarMatch newMatch = new UnoWarMatch(ai1,ai2); // a new UnoWarMatch is created with two AIs
                double winRateOutput = newMatch.winRate(nTrials);
                System.out.println(ai1 + " vs. " + ai2 + " winRate: " + winRateOutput);
            }
        }
    }
}