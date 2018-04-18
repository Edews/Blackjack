import javax.swing.JLabel;

public class dealer extends Hand {

	public dealer(String name) {
		super(name);
	}
	
	public void drawCard(Deck deck){
		
			
			card_hand.add(deck.deckCard[Deck.deck_top]);
		
			Deck.deck_top--;
			Main.window.info.setText(null);
			Main.window.info.append(this.name + " draws a " + card_hand.get(handCount).getRankName() + " of " + 
			card_hand.get(handCount).getSuit() + "\n");


			handCount++;
			
			if(handCount == 1){
				
				label1 = new JLabel(Main.dealer.card_hand.get(handCount-1).getImage());
				Main.window.dealer_card_1.add(label1);
				Main.window.dealer_card_1.setVisible(true);
			}
			else if (/*Main.dealer.*/handCount == 2){
				JLabel label2 = new JLabel(Main.dealer.card_hand.get(handCount-1).getImage());
				Main.window.dealer_card_2.add(label2);
				Main.window.dealer_card_2.setVisible(true);
			}
			total += card_hand.get(handCount-1).getValue();
			Main.window.deal_total.setText(null);
			Main.window.deal_total.append(String.valueOf(this.total));
	}

}
