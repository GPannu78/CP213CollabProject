/**
 * @author Gurnoor Pannu
 * @author Gurbeer Pannu
 * @version 2025-11-20
 */
package cp213;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

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
}
