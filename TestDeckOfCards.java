
/*
 * This is a small simulation to test the Deck of Cards.
 * */
public class TestDeckOfCards {

	public static void main(String[] args) {

		System.out.println("This is small simulation to test the Deck of Cards.");
		System.out.println("The cards are picked in pairs from the deck");
		System.out.println("The card value is used to determine who whon a hand, and the Joker always win.");
		System.out.println("It´s called War, Enjoy");
		System.out.println();

		Deck deck = new Deck(true); // Get a new instance of deck of cards with Jokers
		deck.shuffle(); // Shuffle the deck into a random order before starting
						// the game.
		Card userCard; // The current card, which the user sees.
		Card pcCard; // The PC card.  

		int userGamesWon = 0; // The number of hands won by the user.
		int pcGamesWon = 0; // The number of hands won by the PC.
		
		// Iteraction  until no cards left
		while (deck.cardsLeft() > 0) {
			
			userCard = deck.dealCard();	
			pcCard = deck.dealCard();
			System.out.println("User card is the " + userCard + "\t | PC card is the " + pcCard);

			// evaluates who win
			if (pcCard.getValue() == userCard.getValue()) {
				System.out.println("TIE: Both cards have the same value.");
				System.out.println("War declared: Pick next pair of cards.");
				continue;				
			} else if (pcCard.getValue() > userCard.getValue()) {
				// PC won
				System.out.println("PC Win this hand.");
				pcGamesWon++;
			} else {
				System.out.println("You win this hand.");
				userGamesWon++;
			}
		}// End of While 
		
		// Who won the game		
		if (userGamesWon  == pcGamesWon) {
			System.out.println("=================");
			System.out.println("TIE: Draw heat.");
			System.out.println("=================");
		} else if (userGamesWon  > pcGamesWon) {
			// PC won
			System.out.println("=================");
			System.out.println("PC Win this Game.");
			System.out.println("=================");			
		} else {
			System.out.println("=================");
			System.out.println("You Win this Game.");
			System.out.println("=================");
		}


	} // End of Main


} // End of Class TestDeskCards
