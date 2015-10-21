
public class Deck {

    private Card[] deck; // Collection of Cards in the deck 

    private int cardsUsed;

    /**
     * Constructs a regular 52-card poker deck, without Jokers
     */
    public Deck() {
        this(false);  // Just call the other constructor in this class.
    }

    /**
     * Constructs the deck, Initially the cards are in a sorted order.  
     * The shuffle() method can be called to randomize the order.
     * @param includeJokers if true, two Jokers are included in the deck; if false,
     * there are no Jokers in the deck.
     */
    public Deck(boolean includeJokers) {
        if (includeJokers)
            deck = new Card[54];
        else
            deck = new Card[52];
        
        int cardCount = 0; 
        for ( int suit = 0; suit <= 3; suit++ ) {
            for ( int value = 1; value <= 13; value++ ) {
                deck[cardCount] = new Card(value,suit);
                cardCount++;
            }
        }
        if (includeJokers) {
            deck[52] = new Card(13,Card.JOKER);
            deck[53] = new Card(14,Card.JOKER);
        }
        cardsUsed = 0;
    }

    public int cardsLeft() {
        return deck.length - cardsUsed;
    }

    /**
     * Removes the next card from the deck and return it.  
     * @throws IllegalStateException if there are no cards left in the deck
     */
    public Card dealCard() {
        if (cardsUsed == deck.length)
            throw new IllegalStateException("No cards are left in the deck.");
        cardsUsed++;
        return deck[cardsUsed - 1];
    }

    public boolean hasJokers() {
        return (deck.length == 54); // 54 Contains 2 Jokers
    }

    
    /**
     * Put all the used cards back into the deck (if any), and
     * shuffle the deck into a random order.
     */
    public void shuffle() {
        for ( int i = deck.length-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardsUsed = 0;
    }

} // end class Deck