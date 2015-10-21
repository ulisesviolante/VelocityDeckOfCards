
import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> hand; // The cards in the hand.

	/**
	 * Create a hand that is initially empty.
	 */
	public Hand() {
		hand = new ArrayList<Card>();
	}

	public void addCard(Card card) {
		if (card == null)
			throw new NullPointerException("Cards Can't be null in the Hand.");
		hand.add(card);
	}

	/**
	 * Leaving empty the hand, removing all cards.
	 */
	public void clear() {
		hand.clear();
	}

	/**
	 * @throws IllegalArgumentException
	 *             if position does not exist in the hand
	 */
	public Card getCard(int position) {
		if (position < 0 || position >= hand.size())
			throw new IllegalArgumentException("Position does not exist in hand: " + position);
		return hand.get(position);
	}

	public int getCardCount() {
		return hand.size();
	}

	public void removeCard(Card card) {
		hand.remove(card);
	}

	/**
	 * Remove the card in a specified position from the hand.
	 * 
	 * @throws IllegalArgumentException
	 *             if the position does not exist in the hand,
	 */
	public void removeCard(int position) {
		if (position < 0 || position >= hand.size())
			throw new IllegalArgumentException("Position does not exist in hand: " + position);
		hand.remove(position);
	}

	public void sortBySuit() {
		ArrayList<Card> newHand = new ArrayList<Card>();
		while (hand.size() > 0) {
			int pos = 0;
			Card c = hand.get(0);
			for (int i = 1; i < hand.size(); i++) {
				Card c1 = hand.get(i);
				if (c1.getSuit() < c.getSuit() || (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue())) {
					pos = i;
					c = c1;
				}
			}
			hand.remove(pos);
			newHand.add(c);
		}
		hand = newHand;
	}

	public void sortByValue() {
		ArrayList<Card> newHand = new ArrayList<Card>();
		while (hand.size() > 0) {
			int pos = 0; // Position of minimal card.
			Card c = hand.get(0); // Minimal card.
			for (int i = 1; i < hand.size(); i++) {
				Card c1 = hand.get(i);
				if (c1.getValue() < c.getValue() || (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit())) {
					pos = i;
					c = c1;
				}
			}
			hand.remove(pos);
			newHand.add(c);
		}
		hand = newHand;
	}

} // End Class Hand
