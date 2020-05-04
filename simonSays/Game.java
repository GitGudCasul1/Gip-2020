package simonSays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game {
	String sequence = "";
	String input = "";
	int gameScore = 0;
	JButton blue, yellow, green, red;
	int sequenceCounter = 0;
	Timer t = new Timer(2000, makesequenceActionListener());
	
	public static void main(String[] args) { //this is the main method, this is where you run other methods
		Game game = new Game()	;
		JFrame frame = new JFrame();
		frame.setSize(900,600);
		JPanel panel = new JPanel();
		
		game.buttons(panel);
		game.simon(4);
		
		frame.add(panel);
		frame.setVisible(true);
	}
	
	private void buttons(JPanel panel) { //this method creates the buttons
		
		red = new JButton("red");
		red.setBackground(Color.red);
		red.setPreferredSize(new Dimension(200, 100));
		red.addActionListener(new ActionListener() {			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				input("R");				
			}
		});
		
		green = new JButton("green");
		green.setBackground(Color.green);
		green.setPreferredSize(new Dimension(200, 100));
		green.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				input("G");				
			}
		});
		
		yellow = new JButton("yellow");
		yellow.setBackground(Color.yellow);
		yellow.setPreferredSize(new Dimension(200, 100));
		yellow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				input("Y");
			}
		});
		
		blue = new JButton("blue");
		blue.setBackground(Color.blue);
		blue.setPreferredSize(new Dimension(200, 100));
		blue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				input("B");
			}
		});
		
		JButton start = new JButton("Start");
		start.setPreferredSize(new Dimension(100,50));
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				controleinput();
				showSequence();
			}

		});
				
		panel.add(red);
		panel.add(green);
		panel.add(yellow);
		panel.add(blue);
		panel.add(start);
	}
	
	private void veranderkleur(JButton kleurknop) {
		Color orignelekleur = kleurknop.getBackground();
		kleurknop.setBackground(Color.WHITE);
		Timer t = new Timer(2000, new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	kleurknop.setBackground(orignelekleur);
		    }
		});
		t.start();
	}
	
	private ActionListener makesequenceActionListener() {
		return new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (sequenceCounter > sequence.length() - 1) {
		    		sequenceCounter = 0;
		    		t.stop();
		    	}
		    	
		    	char c = sequence.charAt(sequenceCounter);
		    	sequenceCounter++;
		    	if (c == 'Y') {
		    		veranderkleur(yellow);		    		
		    	}
		    	if (c == 'R') {
		    		veranderkleur(red);		    		
		    	}
		    	if (c == 'G') {
		    		veranderkleur(green);		    		
		    	}
		    	if (c == 'B') {
		    		veranderkleur(blue);		    		
		    	}
		    }
		};
	}
	
	
	private void showSequence() {
		
		
		t.setRepeats(true);
		t.setInitialDelay(0);
		t.start();
		
//		for (char c : sequence.toCharArray()) {
//			if (c == 'Y') {
//				veranderkleur(yellow);	
//			}
//			if (c == 'R') {
//				veranderkleur(red);	
//			}
//			if (c == 'G') {
//				veranderkleur(green);	
//			}
//			if (c == 'B') {
//				veranderkleur(blue);	
//			}
//		}
	}
	
	
	
	private void simon(int length) { //this method creates a random pattern of letters
		String[] array = {"R", "G", "Y","B"};
		Random r = new Random();
		
		for (int i = 0; i < length; i++) {
			int randomNumber = r.nextInt(array.length);
			sequence = sequence + array[randomNumber];			
		}
		
		System.out.println(sequence);		//test
	}
	
	private void input(String kleur) { //this method is what happens when you press a button
		input = input + kleur;
		System.out.println(input);
	}
	
	private void controleinput() { //this method is work in progress
		if(input == sequence) {
			System.out.println("WIN");
		} else {
			System.out.println("LOSE");
		}
	}
}