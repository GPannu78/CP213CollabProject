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

	    JLabel header = new JLabel("Instructions", SwingConstants.CENTER);
	    header.setFont(new Font("Arial", Font.BOLD, 30));

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
