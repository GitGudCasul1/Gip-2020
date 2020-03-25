package simonSays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game {
	public static void main(String[] args) {
		Game game = new Game()	;
		JFrame frame = new JFrame();
		frame.setSize(900,600);
		JPanel panel = new JPanel();
		
		game.buttons(panel);
		game.simon();
		game.input();
		
		frame.add(panel);
		frame.setVisible(true);
	}
	
	private void buttons(JPanel panel) {
		JButton red = new JButton("red");
		red.setBackground(Color.red);
		red.setPreferredSize(new Dimension(200, 100));
		
		JButton green = new JButton("green");
		green.setBackground(Color.green);
		green.setPreferredSize(new Dimension(200, 100));
		
		JButton yellow = new JButton("yellow");
		yellow.setBackground(Color.yellow);
		yellow.setPreferredSize(new Dimension(200, 100));
		
		JButton blue = new JButton("blue");
		blue.setBackground(Color.blue);
		blue.setPreferredSize(new Dimension(200, 100));
				
		panel.add(red);
		panel.add(green);
		panel.add(yellow);
		panel.add(blue);
	}
	
	private void simon() {
		String[] array = {"R", "G", "Y","B"};
		Random r = new Random();
		int randomNumber = r.nextInt(array.length);
		
		String sequence = "";
		sequence = sequence + array[randomNumber];
		
		System.out.println(sequence);
	}
	
	private void input() {
		String input = "";
	}
}
