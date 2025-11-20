/**
 * @author Gurnoor Pannu
 * @author Gurbeer Pannu
 * @version 2025-11-20
 */
package cp213;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JLabel label1, label2;
    private JButton b1, b2, b3, b4;
    private int correct = 0;

    public class InstructionsScreen {

	public JPanel getPanel() {
	    JPanel panel = new JPanel();
	    panel.setLayout(new BorderLayout());

	    JLabel header = new JLabel("Instructions", SwingConstants.CENTER);
	    header.setFont(new Font("Arial", Font.BOLD, 30));

	    return panel;
	}
    }

    public TriviaGUI(ArrayList<McQuestions> list1) {
	this.q1 = list1;
	frame1 = new JFrame("Who Want to be a Millionaire?");
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.setSize(350, 500);
	frame1.setLayout(new BorderLayout());

	label1 = new JLabel("", SwingConstants.CENTER);
	label1.setFont(new Font("Arial", Font.BOLD, 20));
	label2 = new JLabel("", SwingConstants.CENTER);
	label2.setFont(new Font("Arial", Font.PLAIN, 20));
	JPanel p1 = new JPanel(new GridLayout(2, 2));

	frame1.add(p1, BorderLayout.CENTER);
	frame1.add(label1, BorderLayout.NORTH);

	b1 = new JButton();
	b2 = new JButton();
	b3 = new JButton();
	b4 = new JButton();

	p1.add(b1);
	p1.add(b2);
	p1.add(b3);
	p1.add(b4);

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

	frame1.setVisible(false);
    }

    private void qload() {
	McQuestions q2 = q1.get(index);

	label1.setText(q2.getQuestion());

	String[] options1 = q2.getOptions();

	b1.setText(options1[0]);
	b2.setText(options1[0]);
	b3.setText(options1[0]);
	b4.setText(options1[0]);
    }

    private void checka(int n) {
	McQuestions q2 = q1.get(index);

	if (n == q2.getIndexAns()) {
	    label2.setText("Correct. " + q2.getexpl());
	    correct++;
	} else {
	    label2.setText("Incorrect. " + q2.getexpl());
	}

	index++;

	if (index == 15) {
	    label1.setText("Game Over! You got " + correct + " correct out of 15");
	    b1.setEnabled(false);
	    b2.setEnabled(false);
	    b3.setEnabled(false);
	    b4.setEnabled(false);
	} else {
	    qload();
	}

    }

}
