/**
 * @author Gurnoor Pannu
 * @author Gurbeer Pannu
 * @version 2025-11-20
 */
package cp213;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

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
    private ArrayList<McQuestions> q1;
    private JFrame frame1;
    private JLabel label1;

    public class InstructionsScreen {

	public JPanel getPanel() {
	    JPanel panel = new JPanel();
	    panel.setLayout(new BorderLayout());

	    // Header of instructions screen
	    JLabel header = new JLabel("Instructions", SwingConstants.CENTER);
	    header.setFont(new Font("Arial", Font.BOLD, 25));
	    panel.add(header, BorderLayout.NORTH);

	    // Instructions body
	    JTextArea instructions = new JTextArea(
		    "1. Read each question carefully and select the correct answer out of 4.\n"
			    + "2. If you answer correctly, then you move onto to the next prize level.\n"
			    + "3. If you answer incorrectly, then you lose everything.\n"
			    + "4. Use the 50/50 lifeline to remove two wrong answers only once.\n"
			    + "5. Click \"Walk Away\" to stop and take the money earned.\n "
			    + "6. To become the millionare, answer all 15 questions correctly.");

	    instructions.setFont(new Font("Arial", Font.PLAIN, 15));
	    instructions.setBackground(panel.getBackground());
	    panel.add(instructions, BorderLayout.CENTER);

	    return panel;
	}
    }

    private JButton b1, b2, b3, b4;

    public TriviaGUI(ArrayList<McQuestions> list1) {
	this.q1 = list1;
	frame1 = new JFrame("Who Want to be a Millionaire?");
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.setSize(350, 500);
	frame1.setLayout(new BorderLayout());

	label1 = new JLabel("", SwingConstants.CENTER);
	JPanel p1 = new JPanel(new GridLayout(2, 2));

	frame1.add(p1, BorderLayout.CENTER);
	frame1.add(label1, BorderLayout.NORTH);

    }
}
