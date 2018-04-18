
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class Hand {
	protected String name;
	protected int points;
	protected int handCount;
	protected int total;
	protected JLabel label1;
	protected List<Card> card_hand = new ArrayList<Card>();
	
	public Hand (String name){
		this.name = name;
		total = 0;
 }
	
	public String getName(){
		return name;
	}
	
	public void drawCard(Deck deck){
		
	
			
		card_hand.add(deck.deckCard[Deck.deck_top]);
	
		Deck.deck_top--;
		Main.window.info.setText(null);
		Main.window.info.append(this.name + " draws a " + card_hand.get(handCount).getRankName() + " of " + 
		card_hand.get(handCount).getSuit() + "\n");

	
		handCount++;
		
		if(this.getName() == "Dealer" && handCount == 1){
			
			label1 = new JLabel(Main.dealer.card_hand.get(handCount-1).getImage());
			Main.window.dealer_card_1.add(label1);
			Main.window.dealer_card_1.setVisible(true);
		}
		else if (Main.dealer.handCount == 2){
			JLabel label2 = new JLabel(Main.dealer.card_hand.get(handCount-1).getImage());
			Main.window.dealer_card_2.add(label2);
			Main.window.dealer_card_2.setVisible(true);
		}
		
		if (Main.player.handCount == 1){
			JLabel label3 = new JLabel(Main.player.card_hand.get(handCount-1).getImage());
			Main.window.player_card_1.add(label3);
			Main.window.player_card_1.setVisible(true);
		}else if(Main.player.handCount == 2){
			JLabel label4 = new JLabel(Main.player.card_hand.get(handCount-1).getImage());
			Main.window.player_card_2.add(label4);
			Main.window.player_card_2.setVisible(true);
		}else if(Main.player.handCount == 3){
			JLabel label5 = new JLabel(Main.player.card_hand.get(handCount-1).getImage());
			Main.window.player_card_3.add(label5);
			Main.window.player_card_3.setVisible(true);
		}else if(Main.player.handCount == 4){
			JLabel label6 = new JLabel(Main.player.card_hand.get(handCount-1).getImage());
			Main.window.player_card_4.add(label6);
			Main.window.player_card_4.setVisible(true);
		}else if(Main.player.handCount == 5){
			JLabel label7 = new JLabel(Main.player.card_hand.get(handCount-1).getImage());
			Main.window.player_card_5.add(label7);
			Main.window.player_card_5.setVisible(true);
		}
		AceChecker(deck);
	
		
		
		
		
	}
	
	public void overFlow(Hand opponent){
		if (Main.player.total > 21){
		
			Main.window.info.append("The player has exceeded 21\n");
			scoreCheck(opponent);
		}
	}
	
	public void AceChecker(Deck deck){
		if (this.getName() == "Player" && card_hand.get(handCount-1).getRankName() == "Ace" && total < 10 && handCount > 1){
		
			Main.window.info.setText(null);
		
		
			Main.window.btnHit.setVisible(false);
			Main.window.btnPass.setVisible(false);
			Main.window.ace_1.setVisible(true);
			Main.window.ace_11.setVisible(true);

		}else{
			total += card_hand.get(handCount-1).getValue();
		
			Main.window.play_total.setText(null);
			Main.window.play_total.append(String.valueOf(this.total));
	
			
		}
	
	}
	

	
	public void scoreCheck(Hand opponent){

		
		Main.window.info.append("The " + opponent.getName() + " has " + opponent.total + ", and " + this.getName() + " has " + this.total + "\n");
		if (opponent.total > this.total || this.total > 21){
	
			Main.window.info.append("Sorry, pal. You lose\n");
			opponent.points++;
		} else if (this.total > opponent.total){
		
			Main.window.info.append("Yay, you win!\n");
			this.points++;
			
		} else {
		
			Main.window.info.append("Draw\n");
			
		}

		Main.window.deal_score.setText(null);
		Main.window.deal_score.append(opponent.name + ": " + opponent.points);
		Main.window.play_score.setText(null);
		Main.window.play_score.append(this.name + ": " + this.points);
		action();

	}
	
	public static void action(){
		Main.window.btnHit.setVisible(false);
		Main.window.btnPass.setVisible(false);
		Main.window.btnTry.setVisible(true);
	}
}

