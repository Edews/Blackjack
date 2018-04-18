import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Deck  {
	private int maxSize;
	protected int top;
	protected static int deck_top = 51;

	 Card[] deckCard;
	private Card swap;
	private ImageIcon image;
	public Deck(){
		
		deckCard = new Card[52];
		top = -1;
}
	
	
	
	public void createDeck()
    {

		
        String[] suit = {"clubs", "diamonds", "hearts", "spades"};
        int[] rank = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        

        for (int i = 0; i < rank.length; i ++)
        {
            for (int j = 0; j < suit.length; j++)
            {
            	ImageIcon image = new ImageIcon(this.getClass().getResource("cards/" + rank[i] + "_of_" + suit[j] + ".png"));

				
                deckCard[++top] = new Card(rank[i], suit[j], image);
                
                
            } 
        } 
    } //end createDeck()
	
	public void shuffleDeck(){
		Card swap;
		
		for (int i = 0; i < deckCard.length; i++) 
        {
            int r = i + (int) (Math.random() * (deckCard.length - i));
            swap = deckCard[i];
            deckCard[i] = deckCard[r];
            deckCard[r] = swap;
        }
    } // end shuffleDeck()
	public void reset(Hand player, Hand dealer, Deck deck){
		player.card_hand.clear();
		player.handCount = 0;
		player.total = 0;
		
		dealer.card_hand.clear();
		dealer.handCount = 0;
		dealer.total = 0;
		
		top = -1;
		deck_top = 51;
		Arrays.fill(deckCard, null);
	}





}



