package cp213;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * TriviaGUI class definition: This class handles all the GUI portion of this
 * game, it handles instructions, game and end screen along with all helper
 * methods like qload and checka used in the GUI game for smooth user
 * interaction
 * 
 * @author Gurnoor Pannu
 * @author Gurbeer Pannu
 * @version 2025-11-23
 */
public class TriviaGUI {
    // Instance variables to be used in multiple methods
    private int index = 0;
    private ArrayList<Questions> q1;
    private JFrame frame1;
    private JLabel label1, label2;
    private int correct = 0;
    private int answered = 0;
    private JButton b1, b2, b3, b4;
    private JButton ffButton;
    private JButton skipButton;
    private JButton walkAway;
    private JLabel cash;
    private int[] cashl = { 0, 100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 250000, 500000,
	    1000000 };

    // Creating variables for color for easier changes
    Color backgroundColour = new Color(169, 0, 211);
    Color buttonColour = new Color(255, 195, 0);

    /**
     * Instantiates a TriviaGUI object.
     *
     * @param ArrayList of Questions type
     */
    public TriviaGUI(ArrayList<Questions> list1) {
	this.q1 = list1;
    }

    /**
     * Creates a GameGUI (main game screen), where user plays trivia game all labels
     * and buttons are created and set for user interaction this method also handles
     * actionperformed for each button
     *
     */
    public void GameGUI() {
	// Creating main frame
	frame1 = new JFrame("Who Want to be a Millionaire?");
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.setSize(350, 500);
	frame1.setLayout(new BorderLayout());
	frame1.setBackground(backgroundColour);

	// Creating labels and buttons and setting their attributes
	// Also changing colors for all attributes
	JLabel title = new JLabel("Who Wants to be a Millionarie!", SwingConstants.CENTER);
	title.setFont(new Font("Arial", Font.BOLD, 20));
	frame1.add(title, BorderLayout.NORTH);
	title.setOpaque(true);
	title.setBackground(backgroundColour);
	title.setForeground(buttonColour);

	JPanel center = new JPanel(new BorderLayout());

	label1 = new JLabel("", SwingConstants.CENTER);
	label1.setFont(new Font("Arial", Font.BOLD, 12));
	label1.setPreferredSize(new Dimension(50, 50));
	label1.setForeground(buttonColour);
	center.add(label1, BorderLayout.NORTH);
	center.setBackground(backgroundColour);

	JPanel p2 = new JPanel(new GridLayout(2, 2, 10, 10));
	p2.setBackground(backgroundColour);
	b1 = new JButton();
	b2 = new JButton();
	b3 = new JButton();
	b4 = new JButton();

	b1.setPreferredSize(new Dimension(110, 30));
	b2.setPreferredSize(new Dimension(110, 30));
	b3.setPreferredSize(new Dimension(110, 30));
	b4.setPreferredSize(new Dimension(110, 30));

	b1.setBackground(buttonColour);
	b2.setBackground(buttonColour);
	b3.setBackground(buttonColour);
	b4.setBackground(buttonColour);
	b1.setForeground(backgroundColour);
	b2.setForeground(backgroundColour);
	b3.setForeground(backgroundColour);
	b4.setForeground(backgroundColour);

	p2.add(b1);
	p2.add(b2);
	p2.add(b3);
	p2.add(b4);

	ffButton = new JButton("50/50");
	skipButton = new JButton("Skip");
	walkAway = new JButton("Walk Away");
	ffButton.setBackground(buttonColour);
	skipButton.setBackground(buttonColour);
	walkAway.setBackground(buttonColour);
	ffButton.setForeground(backgroundColour);
	skipButton.setForeground(backgroundColour);
	walkAway.setForeground(backgroundColour);

	JPanel LifeLines = new JPanel();
	LifeLines.add(ffButton);
	LifeLines.add(skipButton);
	LifeLines.add(walkAway);
	LifeLines.setBackground(backgroundColour);

	center.add(p2, BorderLayout.CENTER);
	JPanel bottomStack = new JPanel(new GridLayout(2, 1));
	bottomStack.setBackground(backgroundColour);

	cash = new JLabel("Prize: $0", SwingConstants.CENTER);
	cash.setFont(new Font("Arial", Font.PLAIN, 14));
	cash.setOpaque(true);
	cash.setBackground(backgroundColour);
	cash.setForeground(buttonColour);

	bottomStack.add(LifeLines);
	bottomStack.add(cash);
	center.add(bottomStack, BorderLayout.SOUTH);
	frame1.add(center, BorderLayout.CENTER);

	label2 = new JLabel("-------", SwingConstants.CENTER);
	label2.setFont(new Font("Arial", Font.PLAIN, 12));
	label2.setPreferredSize(new Dimension(50, 50));
	label2.setOpaque(true);
	label2.setBackground(backgroundColour);
	label2.setForeground(buttonColour);

	frame1.add(label2, BorderLayout.SOUTH);

	// Actionlistener for all buttons along with each anctionperformed method
	ffButton.addActionListener(new ActionListener() {
	    @Override
	    /**
	     * This method is used when fifty fifty button is clicked. The method sets two
	     * of the wrong option buttons setenabled false so user cannot click the options
	     *
	     */
	    public void actionPerformed(ActionEvent e) {

		Questions q2 = q1.get(index);
		int corrindex = q2.getIndexAns();

		int r = 0;
		JButton[] buttons = { b1, b2, b3, b4 };

		for (int i = 0; i < 4 && r < 2; i++) {
		    if (i != corrindex) {
			buttons[i].setEnabled(false);
			r++;
		    }

		}
		ffButton.setEnabled(false);
	    }
	});

	skipButton.addActionListener(new ActionListener() {
	    @Override
	    /**
	     * This method is called when skip button is clicked. This method skips question
	     * but does not increase score, cash label or index
	     *
	     */
	    public void actionPerformed(ActionEvent e) {

		skipButton.setEnabled(false);

		index++;
		if (index >= q1.size()) {
		    index = q1.size() - 1;
		}

		b1.setEnabled(true);
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);

		qload();

	    }
	});

	walkAway.addActionListener(new ActionListener() {
	    @Override
	    /**
	     * This method is called when the user clicks walk away button. This methods
	     * takes user to end screen.
	     *
	     */
	    public void actionPerformed(ActionEvent e) {
		EndScreen();
	    }

	});

	/**
	 * All buttons action listener and aciton performed. Each action performed calls
	 * checka with the appropriate index for each button
	 */
	b1.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		checka(0);
	    }
	});
	b2.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		checka(1);
	    }
	});
	b3.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		checka(2);
	    }
	});
	b4.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		checka(3);
	    }
	});

	qload();
	frame1.setVisible(true);
    }

    /**
     * Creates InstructionsScreen, this method handles all variables of the
     * instructions screen and their appropriate attributes
     */
    public void InstructionsScreen() {
	// Main frame
	frame1 = new JFrame("Instructions");
	JPanel panel = new JPanel(new BorderLayout());
	panel.setBackground(backgroundColour);

	// Header of instructions screen
	JLabel header = new JLabel("Instructions", SwingConstants.CENTER);
	header.setFont(new Font("Arial", Font.BOLD, 25));
	header.setForeground(buttonColour);
	panel.add(header, BorderLayout.NORTH);

	// Instructions body
	JTextArea instructions = new JTextArea(
		"HOW TO PLAY:\n\n" + "1. Read each question carefully and select the \n    correct answer out of 4.\n"
			+ "2. If you answer correctly, then you move onto to \n    the next prize level.\n"
			+ "3. If you answer incorrectly, then you lose \n    everything.\n"
			+ "4. Use the 50/50 lifeline to remove two wrong \n    answers only once.\n"
			+ "5. Click \"Walk Away\" to stop and take the money \n    earned.\n"
			+ "6. To become the millionare, answer all 15 \n    questions correctly.\n\n" + "LIFELINES:\n\n"
			+ "50/50 - Removes two wrong choices.\n" + "Skip - Skips the current question.\n\n");

	instructions.setFont(new Font("Arial", Font.PLAIN, 15));
	instructions.setEditable(false);
	instructions.setBackground(panel.getBackground());
	instructions.setForeground(buttonColour);
	instructions.setMargin(new Insets(10, 10, 10, 10));
	panel.add(instructions, BorderLayout.CENTER);
	// Start button
	JButton start = new JButton("Start Game");
	start.setBackground(buttonColour);
	start.setForeground(backgroundColour);
	start.setFont(new Font("Arial", Font.BOLD, 15));
	// Calls GameGUI screen when start button is clicked
	start.addActionListener(e -> {
	    GameGUI();
	});
	panel.add(start, BorderLayout.SOUTH);

	frame1.setContentPane(panel);
	frame1.setSize(350, 500);
	frame1.setVisible(true);

    }

    /**
     * Creates EndScreen, this method handles all variables of end screen and all of
     * their attributes
     */
    public void EndScreen() {

	frame1.getContentPane().removeAll();
	JPanel panel = new JPanel(new BorderLayout());
	JLabel header = new JLabel("Game Over!", SwingConstants.CENTER);
	header.setFont(new Font("Arial", Font.BOLD, 25));
	panel.add(header, BorderLayout.NORTH);

	JLabel score = new JLabel("<html><div style='text-align:center;'>You scored " + correct
		+ " out of 15<br>   Final Cash: $" + cashl[correct] + "</div></html>", SwingConstants.CENTER);
	score.setFont(new Font("Arial", Font.PLAIN, 15));
	panel.add(score, BorderLayout.CENTER);
	panel.setBackground(backgroundColour);

	JButton restart = new JButton("Play Again");
	restart.setFont(new Font("Arial", Font.BOLD, 15));
	/**
	 * If restart button is clicked, shuffle question list to change order of
	 * questions and set appropriate variables to 0 for smooth user interaction when
	 * playing game again
	 */
	restart.addActionListener(e -> {
	    Collections.shuffle(q1);
	    index = 0;
	    correct = 0;
	    answered = 0;
	    InstructionsScreen();
	});
	panel.add(restart, BorderLayout.SOUTH);
	restart.setBackground(buttonColour);
	restart.setForeground(backgroundColour);
	header.setForeground(buttonColour);
	score.setForeground(buttonColour);

	b1.setEnabled(false);
	b2.setEnabled(false);
	b3.setEnabled(false);
	b4.setEnabled(false);

	frame1.setContentPane(panel);
	frame1.revalidate();
	frame1.repaint();

    }

    /**
     * Helper method used only in this class, this method is used to load questions
     * smoothly while also handling all unexpected cases
     */
    private void qload() {

	try {
	    b1.setEnabled(true);
	    b2.setEnabled(true);
	    b3.setEnabled(true);
	    b4.setEnabled(true);
	    Questions q2 = q1.get(index);
	    label1.setText("<html>" + q2.getQuestion() + "</html>");
	    String[] options1 = q2.getOptions();

	    if (options1.length == 4) {
		b1.setText(options1[0]);
		b2.setText(options1[1]);
		b3.setText(options1[2]);
		b4.setText(options1[3]);
	    } else {
		throw new Exception("Question does not have exactly 4 options.");
	    }
	} catch (IndexOutOfBoundsException e) {
	    System.err.print("Error, Question index out of bounds." + e.getMessage());
	    EndScreen();
	} catch (Exception e) {
	    System.err.print("Error with loading question." + e.getMessage());
	    EndScreen();
	}
    }

    /**
     * Helper method used only in this class, this method is used to check answer
     * and display the resulting outputs accordingly, this method also handles all
     * unexpected cases
     */
    private void checka(int n) {
	try {
	    Questions q2 = q1.get(index);
	    if (n == q2.getIndexAns()) {
		label2.setText("<html>" + "Correct. " + q2.getexpl() + "</html>");
		correct++;
		cash.setText("Prize: $" + cashl[correct]);
	    } else {
		label2.setText("<html>" + "Incorrect. " + q2.getexpl() + "</html>");
	    }
	    index++;
	    if (index >= q1.size()) {
		index = q1.size() - 1;
	    }
	    answered++;
	    if (answered == 15) {
		EndScreen();
	    } else {
		qload();
	    }
	} catch (IndexOutOfBoundsException e) {
	    System.err.println("Error: Question index out of bounds. " + e.getMessage());
	    EndScreen();
	} catch (Exception e) {
	    System.err.println("Error checking answer: " + e.getMessage());
	    EndScreen();
	}
    }
}