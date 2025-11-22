/**
 * @author Gurnoor Pannu
 * @author Gurbeer Pannu
 * @version 2025-11-20
 */
package cp213;

import java.awt.BorderLayout;
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
 * 
 */
public class TriviaGUI {
    private int index = 0;
    private ArrayList<Questions> q1;
    private JFrame frame1;
    private JLabel label1, label2;
    private int correct = 0;
    private int answered = 0;
    private JButton b1, b2, b3, b4;
    private JButton ffButton;
    private JButton skipButton;

    public TriviaGUI(ArrayList<Questions> list1) {
	this.q1 = list1;
	InstructionsScreen();
    }

    public void GameGUI() {
	frame1 = new JFrame("Who Want to be a Millionaire?");
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.setSize(350, 500);
	frame1.setLayout(new BorderLayout());

	JLabel title = new JLabel("Who Wants to be a Millionarie!", SwingConstants.CENTER);
	title.setFont(new Font("Arial", Font.BOLD, 20));
	frame1.add(title, BorderLayout.NORTH);

	JPanel center = new JPanel(new BorderLayout());

	label1 = new JLabel("", SwingConstants.CENTER);
	label1.setFont(new Font("Arial", Font.BOLD, 12));
	label1.setPreferredSize(new Dimension(50, 50));
	center.add(label1, BorderLayout.NORTH);

	JPanel p2 = new JPanel(new GridLayout(2, 2, 10, 10));
	b1 = new JButton();
	b2 = new JButton();
	b3 = new JButton();
	b4 = new JButton();

	b1.setPreferredSize(new Dimension(110, 30));
	b2.setPreferredSize(new Dimension(110, 30));
	b3.setPreferredSize(new Dimension(110, 30));
	b4.setPreferredSize(new Dimension(110, 30));

	p2.add(b1);
	p2.add(b2);
	p2.add(b3);
	p2.add(b4);

	ffButton = new JButton("50/50 LifeLine");
	skipButton = new JButton("Skip Question");

	JPanel LifeLines = new JPanel();
	LifeLines.add(ffButton);
	LifeLines.add(skipButton);

	center.add(p2, BorderLayout.CENTER);
	center.add(LifeLines, BorderLayout.SOUTH);
	frame1.add(center, BorderLayout.CENTER);

	label2 = new JLabel("Score: 0", SwingConstants.CENTER);
	label2.setFont(new Font("Arial", Font.PLAIN, 12));
	label2.setPreferredSize(new Dimension(50, 50));

	frame1.add(label2, BorderLayout.SOUTH);

	ffButton.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {

		Questions q2 = q1.get(index);
		String[] options = q2.getOptions();
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

    public void InstructionsScreen() {

	frame1 = new JFrame("Instructions");
	JPanel panel = new JPanel();
	panel.setLayout(new BorderLayout());

	// Header of instructions screen
	JLabel header = new JLabel("Instructions", SwingConstants.CENTER);
	header.setFont(new Font("Arial", Font.BOLD, 25));
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
	instructions.setMargin(new Insets(10, 10, 10, 10));
	panel.add(instructions, BorderLayout.CENTER);
	// Start button
	JButton start = new JButton("Start Game");
	start.setFont(new Font("Arial", Font.PLAIN, 15));
	start.addActionListener(e -> {
	    GameGUI();
	});
	panel.add(start, BorderLayout.SOUTH);

	frame1.setContentPane(panel);
	frame1.setSize(350, 500);
	frame1.setVisible(true);

    }

    public void EndScreen() {

	frame1.getContentPane().removeAll();
	JPanel panel = new JPanel(new BorderLayout());
	JLabel header = new JLabel("Game Over!", SwingConstants.CENTER);
	header.setFont(new Font("Arial", Font.BOLD, 25));
	panel.add(header, BorderLayout.CENTER);

	JLabel score = new JLabel("You scored " + correct + " out of 15", SwingConstants.CENTER);
	score.setFont(new Font("Arial", Font.PLAIN, 15));
	panel.add(score, BorderLayout.CENTER);

	JButton restart = new JButton("Play Again");
	restart.setFont(new Font("Arial", Font.BOLD, 15));
	restart.addActionListener(e -> {
	    Collections.shuffle(q1);
	    index = 0;
	    correct = 0;
	    InstructionsScreen();
	});
	panel.add(restart, BorderLayout.SOUTH);

	b1.setEnabled(false);
	b2.setEnabled(false);
	b3.setEnabled(false);
	b4.setEnabled(false);

	frame1.setContentPane(panel);
	frame1.revalidate();
	frame1.repaint();

    }

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

    private void checka(int n) {
	try {
	    Questions q2 = q1.get(index);
	    if (n == q2.getIndexAns()) {
		label2.setText("<html>" + "Correct. " + q2.getexpl() + "</html>");
		correct++;
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