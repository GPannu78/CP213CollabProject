/**
 * @author Gurnoor Pannu
 * @version 2025-11-13
 */
package cp213;

/**
 * 
 */
public class McQuestions extends Questions {
    private String expl;

    public McQuestions(String question, String[] options, int indexans, String expl) {
	super(question, options, indexans);
	this.expl = expl;
    }

    public String getexpl() {
	return expl;
    }
}
