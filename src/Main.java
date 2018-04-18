import java.util.Scanner;

import javax.swing.JFrame;

public class Main {
	static window window = new window();
	static JFrame frame = new JFrame();
	static Deck deck = new Deck();
	static player player = new player("Player");
	static dealer dealer = new dealer("Dealer");

	public static void main(String[] args) {
		window.BlackJack.setVisible(true);

		setup();
		window.info.setText(null);
		window.info.append("Welcome to a game of Black Jack");
	}

	public static void setup() {
		deck.reset(player, dealer, deck);
		deck.createDeck();
		deck.shuffleDeck();

		dealer.drawCard(deck);
		player.drawCard(deck);
		player.drawCard(deck);

	}

}
