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

public class Game {
	String sequence = "";
	String input = "";
	int gameScore = 0;
	
	public static void main(String[] args) { //this is the main method, this is where you run other methods
		Game game = new Game()	;
		JFrame frame = new JFrame();
		frame.setSize(900,600);
		JPanel panel = new JPanel();
		
		game.buttons(panel);
		game.simon();
		
		frame.add(panel);
		frame.setVisible(true);
	}
	
	private void buttons(JPanel panel) { //this method creates the buttons
		
		JButton red = new JButton("red");
		red.setBackground(Color.red);
		red.setPreferredSize(new Dimension(200, 100));
		red.addActionListener(new ActionListener() {			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				input("R");				
			}
		});
		
		JButton green = new JButton("green");
		green.setBackground(Color.green);
		green.setPreferredSize(new Dimension(200, 100));
		green.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				input("G");				
			}
		});
		
		JButton yellow = new JButton("yellow");
		yellow.setBackground(Color.yellow);
		yellow.setPreferredSize(new Dimension(200, 100));
		yellow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				input("Y");
			}
		});
		
		JButton blue = new JButton("blue");
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
				controleinput();
				
			}
		});
				
		panel.add(red);
		panel.add(green);
		panel.add(yellow);
		panel.add(blue);
		panel.add(start);
	}
	
	private void simon() { //this method creates a random pattern of letters
		String[] array = {"R", "G", "Y","B"};
		Random r = new Random();
		int randomNumber = r.nextInt(array.length);
		
		sequence = sequence + array[randomNumber];
		
		System.out.println(sequence);		//test
	}
	
	private String input(String kleur) { //this method is what happens when you press a button
		input = input + kleur;
		System.out.println(input);
		return input;
	}
	
	private void controleinput() { //this method is work in progress
		if(input == sequence) {
			System.out.println("WIN");
		} else {
			System.out.println("LOSE");
		}
	}
}
