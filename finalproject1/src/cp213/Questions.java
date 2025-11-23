package cp213;

/**
 * Questions class definition: Stores and displays questions, allowing the user
 * to see the current question to answer. Then, checks the answer given by the
 * user to see if it's correct or not.
 * 
 * @author Gurnoor Pannu
 * @author Gurbeer Pannu
 * @version 2025-11-20
 */
public class Questions {

    // Attributes
    protected String question;
    protected String[] options;
    protected int indexans;

    /**
     * Instantiates a Questions object.
     *
     * @param question current question
     * @param options  array list of options
     * @param indexans index of the answer
     */
    public Questions(String question, String[] options, int indexans) {
	this.question = question;
	this.options = options;
	this.indexans = indexans;
    }

    /**
     * Displays the current question
     */
    public void displayq() {
	System.out.println(question);
	for (int i = 0; i < options.length; i++) {
	    System.out.println("Option " + (i + 1) + ": " + options[i]);
	}
    }

    /**
     * Checks the answer given by user
     * 
     * @param ans answer to check
     * @return T/F if answer is correct or not
     */
    public boolean checkans(int ans) {
	return indexans == ans;
    }

    /**
     * Gets the expl (Accessor method)
     * 
     * @return "N/A"
     */
    public String getexpl() {
	return "N/A";
    }

    /**
     * Gets the question (Accessor method)
     * 
     * @return question
     */
    public String getQuestion() {
	return question;
    }

    /**
     * Gets the options (Accessor method)
     * 
     * @return options
     */
    public String[] getOptions() {
	return options;
    }

    /**
     * Gets the Index of answer (Accessor method)
     * 
     * @return indexans
     */
    public int getIndexAns() {
	return indexans;
    }

    /**
     * Sets the question (Mutator method)
     * 
     * @param question that sets
     */
    public void setQuestion(String question) {
	this.question = question;
    }

    /**
     * Sets the options (Mutator method)
     * 
     * @param options that set
     */
    public void setOptions(String[] options) {
	this.options = options;
    }

    /**
     * Sets the Index of answer (Mutator method)
     * 
     * @param Indexans that sets
     */
    public void setIndexAns(int indexans) {
	this.indexans = indexans;
    }
}
