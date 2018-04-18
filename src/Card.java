import java.awt.Image;
import java.awt.image.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Card {
	private String suit;
	private int rank;
	private ImageIcon image;
	
	public Card(int rank, String suit, ImageIcon image){
		this.suit = suit;
		this.rank = rank;
		this.image = image;
		getRankName();
}
	
	
	
	public String getRankName(){
		
		if (rank == 1){
			
			return "Ace";
		}
		else if (rank == 11){
			
			return "Knight";
		}
		else if (rank == 12){
			
			return "Queen";
		}
		else if (rank == 13){
			
			return "King";
		}
		else{
		return String.valueOf(rank);
		}
	}//end getRank()
	
	public int getValue(){
		
		if (rank > 10){
			rank = 10;
		}else if (rank == 1){
			rank = 10;
		}
		
		return rank;
	}
	
	public String getSuit(){
		return suit;
	}
	
	public int getRank(){
	return rank;
	}
	
	public ImageIcon getImage(){
		return image;
	}
	
	public int setRank(int rank){
		this.rank = rank;
		return rank;
	}
	
	
}
