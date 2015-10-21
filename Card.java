

public class Card {

	// Codes for the 4 suits, and Jokers.
	// Defined as constants on behalf to enum (other possibility)
	public final static int CLUB = 0;
	public final static int SPADE = 1;
	public final static int DIAMOND = 2;
	public final static int HEART = 3;
	public final static int JOKER = 4;	

	// Non numeric cards defined as constants too. 
	public final static int ACE = 1; 
	public final static int JACK = 11; 
	public final static int QUEEN = 12; 
	public final static int KING = 13;

	
	private final int suit;
	private final int value;

	/**
	 * "new Card()" is equivalent to "new Card(1,Card.JOKER)".
	 */
	public Card() {
		suit = JOKER;
		value = 13;
	}

	/**
	 * Creates a card with a specified suit and value.
	 * @throws IllegalArgumentException if the parameter values are not in the permissible ranges
	 */
	public Card(int theValue, int theSuit) {
		
		if (theSuit != CLUB &&
				theSuit != SPADE && 
				theSuit != HEART && 
				theSuit != DIAMOND && 
				theSuit != JOKER)
			throw new IllegalArgumentException("Illegal playing card suit");
		if (theSuit != JOKER && (theValue < 1 || theValue > 13)) // Joker is an exception and could have any value. 
			throw new IllegalArgumentException("Illegal playing card value");
		
		this.value = theValue;
		this.suit = theSuit;
	}

	
	// Getters
	public int getSuit() {
		return suit;
	}
	
	public String getSuitAsString() {
		switch (suit) {
		case CLUB:
			return "Clubs";
		case SPADE:
			return "Spades";
		case DIAMOND:
			return "Diamonds";
		case HEART:
			return "Hearts";
		default:
			return "Joker";
		}
	}


	public int getValue() {
		return value;
	}

	
	public String getValueAsString() {
		if (suit == JOKER)
			return "" + value;
		else {
			switch (value) {
			case 1:
				return "Ace";
			case 2:
				return "2";
			case 3:
				return "3";
			case 4:
				return "4";
			case 5:
				return "5";
			case 6:
				return "6";
			case 7:
				return "7";
			case 8:
				return "8";
			case 9:
				return "9";
			case 10:
				return "10";
			case 11:
				return "Jack";
			case 12:
				return "Queen";
			default:
				return "King";
			}
		}
	}

	public String toString() {
		if (suit == JOKER) {
			if (value == 1)
				return "Joker";
			else
				return "Joker #" + value;
		} else
			return getValueAsString() + " of " + getSuitAsString();
	}

} // End Class Card
