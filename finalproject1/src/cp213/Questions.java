/**
 * @author Gurnoor Pannu
 * @version 2025-11-13
 */
package cp213;

/**
 * 
 */
public class Questions {
    protected String question;
    protected String[] options;
    protected int indexans;

    public Questions(String question, String[] options, int indexans) {
	this.question = question;
	this.options = options;
	this.indexans = indexans;
    }

    public void displayq() {
	System.out.println(question);
	for (int i = 0; i < options.length; i++) {
	    System.out.println("Option " + (i + 1) + ": " + options[i]);
	}
    }

    public boolean checkans(int ans) {
	return indexans == ans;
    }

    public String getexpl() {
	return "N/A";
    }
}
