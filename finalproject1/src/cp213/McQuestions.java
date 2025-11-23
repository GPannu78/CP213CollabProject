package cp213;

/**
 * McQuestions class definition: McQuestions class extends (inheritence)
 * Questions class and adds another instance variable expl (explanation of the
 * answer). This class is used to add questions in TriviaMain
 * 
 * @author Gurnoor Pannu
 * @author Gurbeer Pannu
 * @version 2025-11-23
 */
public class McQuestions extends Questions {
    // Instance Variable (Attribute)
    private String expl;

    /**
     * Instantiates a McQuestions object.
     *
     * @param question current question
     * @param options  array list of options
     * @param indexans index of the answer
     * @param expl     explanation of answer
     */
    public McQuestions(String question, String[] options, int indexans, String expl) {
	// call super class (Questions) constructor for three paramaters
	super(question, options, indexans);
	this.expl = expl;
    }

    @Override
    /**
     * Getter for new expl variable (returns expl) overrides method from questions
     * class
     * 
     * @return expl
     */
    public String getexpl() {
	return expl;
    }

    /**
     * Sets the expl (Mutator method)
     * 
     * @param expl that sets
     */
    public void setexpl(String expl) {
	this.expl = expl;
    }
}
