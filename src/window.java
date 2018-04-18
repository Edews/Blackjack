import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.Label;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class window {
	protected JPanel dealer_card_1;
	protected JPanel dealer_card_2;
	protected JPanel player_card_5;
	protected JPanel player_card_4;
	protected JPanel player_card_3;
	protected JPanel player_card_2;
	protected JPanel player_card_1;
	
	protected JButton btnHit;
	protected JButton btnPass;
	protected JButton btnQuit;
	protected JButton btnTry;
	protected JButton ace_1;
	protected JButton ace_11;
	
	protected JTextArea deal_score;
	protected JTextArea play_score;
	
	protected JFrame BlackJack;
	protected JTextArea play_total;
	protected JTextArea deal_total;
	protected JTextArea info;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window window = new window();
					window.BlackJack.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public window() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		BlackJack = new JFrame();
		BlackJack.setTitle("Black Jack");
		BlackJack.setBounds(100, 100, 495, 622);
		BlackJack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BlackJack.getContentPane().setLayout(null);
		
		
		
		dealer_card_1 = new JPanel();
		dealer_card_1.setBackground(Color.WHITE);
		dealer_card_1.setBounds(96, 11, 130, 188);
		BlackJack.getContentPane().add(dealer_card_1);
		dealer_card_1.setVisible(false);
		
		
		
		
		dealer_card_2 = new JPanel();
		dealer_card_2.setBackground(Color.WHITE);
		dealer_card_2.setBounds(268, 11, 130, 188);
		BlackJack.getContentPane().add(dealer_card_2);
		dealer_card_2.setVisible(false);
		
		player_card_5 = new JPanel();
		player_card_5.setBackground(Color.WHITE);
		player_card_5.setBounds(339, 284, 130, 188);
		BlackJack.getContentPane().add(player_card_5);
		player_card_5.setVisible(false);
		
		player_card_4 = new JPanel();
		player_card_4.setBackground(Color.WHITE);
		player_card_4.setBounds(254, 284, 130, 188);
		BlackJack.getContentPane().add(player_card_4);
		player_card_4.setVisible(false);
		
		player_card_3 = new JPanel();
		player_card_3.setBackground(Color.WHITE);
		player_card_3.setBounds(171, 284, 130, 188);
		BlackJack.getContentPane().add(player_card_3);
		player_card_3.setVisible(false);
		
		player_card_2 = new JPanel();
		player_card_2.setBounds(96, 284, 130, 188);
		BlackJack.getContentPane().add(player_card_2);
		player_card_2.setBackground(Color.WHITE);
		player_card_2.setVisible(false);
		
		btnHit = new JButton("Hit");
		btnHit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnHit.setBounds(10, 514, 117, 58);
		btnHit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Main.player.drawCard(Main.deck);
				Main.player.overFlow(Main.dealer);
				
				
			}
			
		});
		BlackJack.getContentPane().add(btnHit);
		
		btnPass = new JButton("Pass");
		btnPass.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnPass.setBounds(184, 514, 117, 58);
		btnPass.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Main.dealer.drawCard(Main.deck);
				//Main.player.overFlow(Main.dealer);
				Main.player.scoreCheck(Main.dealer); //Main.run();
			}
			
		});
		BlackJack.getContentPane().add(btnPass);
		
		btnQuit = new JButton("Quit");
		btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnQuit.setBounds(352, 514, 117, 58);
		btnQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		BlackJack.getContentPane().add(btnQuit);
		
		
		btnTry = new JButton("Try again");
		btnTry.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnTry.setBounds(33, 508, 181, 71);
		btnTry.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main.window.dealer_card_1.removeAll();
				dealer_card_1.setVisible(false);
				Main.window.player_card_1.removeAll();
				player_card_1.setVisible(false);
				Main.window.player_card_2.removeAll();
				player_card_2.setVisible(false);
				
				if(Main.dealer.handCount == 2){
					Main.window.dealer_card_2.removeAll();
					dealer_card_2.setVisible(false);
				}
				
				if (Main.player.handCount == 3){
			Main.window.player_card_3.removeAll();
			player_card_3.setVisible(false);
		}
		if (Main.player.handCount == 4){
			Main.window.player_card_4.removeAll();
			Main.window.player_card_3.removeAll();
			player_card_3.setVisible(false);
			player_card_4.setVisible(false);
		}
		
		if (Main.player.handCount == 5){
			Main.window.player_card_5.removeAll();
			Main.window.player_card_4.removeAll();
			Main.window.player_card_3.removeAll();
			player_card_3.setVisible(false);
			player_card_4.setVisible(false);
			player_card_5.setVisible(false);
		}
				

				btnTry.setVisible(false);
				btnHit.setVisible(true);
				btnPass.setVisible(true);
				
				Main.setup();
				return;
			}});
		BlackJack.getContentPane().add(btnTry);
		btnTry.setVisible(false);
		
		ace_1 = new JButton("1");
		ace_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ace_1.setBounds(10, 514, 117, 58);
		ace_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main.player.card_hand.get(Main.player.handCount-1).setRank(1);
				Main.player.total += Main.player.card_hand.get(Main.player.handCount-1).getRank();
				
				Main.window.play_total.setText(null);
				Main.window.play_total.append(String.valueOf(Main.player.total));
				Main.window.ace_1.setVisible(false);
				Main.window.ace_11.setVisible(false);
				Main.window.btnHit.setVisible(true);
				Main.window.btnPass.setVisible(true);
			}
			
		});
		BlackJack.getContentPane().add(ace_1);
		ace_1.setVisible(false);
		
		ace_11 = new JButton("11");
		ace_11.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ace_11.setBounds(184, 514, 117, 58);
		ace_11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main.player.card_hand.get(Main.player.handCount-1).setRank(11);
				Main.player.total += Main.player.card_hand.get(Main.player.handCount-1).getRank();
				
				Main.window.play_total.setText(null);
				Main.window.play_total.append(String.valueOf(Main.player.total));
				Main.window.ace_1.setVisible(false);
				Main.window.ace_11.setVisible(false);
				Main.window.btnHit.setVisible(true);
				Main.window.btnPass.setVisible(true);
				
			}
			
		});
		BlackJack.getContentPane().add(ace_11);
		ace_11.setVisible(false);
		
		player_card_1 = new JPanel();
		player_card_1.setBackground(Color.WHITE);
		player_card_1.setBounds(10, 284, 133, 188);
		BlackJack.getContentPane().add(player_card_1);
		player_card_1.setVisible(false);
		
		deal_score = new JTextArea("Dealer: 0");
		deal_score.setEditable(false);
		deal_score.setBounds(10, 11, 76, 37);
		BlackJack.getContentPane().add(deal_score);
		
		play_score = new JTextArea("Player: 0");
		play_score.setEditable(false);
		play_score.setBounds(10, 59, 76, 37);
		BlackJack.getContentPane().add(play_score);
		
		play_total = new JTextArea();
		play_total.setEditable(false);
		play_total.setBounds(10, 481, 98, 22);
		BlackJack.getContentPane().add(play_total);
		
		deal_total = new JTextArea();
		deal_total.setEditable(false);
		deal_total.setBounds(17, 162, 69, 22);
		BlackJack.getContentPane().add(deal_total);
		
		info = new JTextArea();
		info.setEditable(false);
		info.setBounds(33, 209, 373, 71);
		BlackJack.getContentPane().add(info);
		
		
		
		
		
		
	}
}
