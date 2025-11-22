/**
 * @author Gurnoor Pannu
 * @author Gurbeer Pannu
 * @version 2025-11-20
 */
package cp213;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
 */
public class TriviaMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner keyboard = new Scanner(System.in);

	ArrayList<Questions> questionlist = new ArrayList<>();

	questionlist.add(new McQuestions("Where is the Mariana Trench located?",
		new String[] { "Atlantic Ocean", "Pacific Ocean", "Indian Ocean", "Arctic Ocean" }, 1,
		"The Mariana Trench is located in the pacific Ocean."));

	questionlist.add(new McQuestions("What fruit has its seeds on the outside?",
		new String[] { "Blueberry", "Strawberry", "Raspberry", "Blackberry" }, 1,
		"Strawberries are the only fruit with seeds on the outside."));

	questionlist.add(new McQuestions("What is the smallest unit of digital information?",
		new String[] { "Bit", "Byte", "Kilobyte", "Megabyte" }, 0,
		"A bit is the smallest unit of digital information."));

	questionlist.add(new McQuestions("What is the smallest country in the world?",
		new String[] { "Monaco", "San Marino", "Vatican City", "Liechtenstein" }, 2,
		"The smalles country in the world is The Vatican City."));

	questionlist.add(new McQuestions("What country has the most islands in the world?",
		new String[] { "Canada", "Indonesia", "Sweden", "Philippines" }, 2,
		"Sweden has the most islands in the world, over 260,000!"));

	questionlist.add(new McQuestions("How many elements are currently on the periodic table?",
		new String[] { "112", "114", "118", "116" }, 2, "Currently there are 118 confirmed elements."));

	questionlist.add(new McQuestions("What is the only food that never spoils?",
		new String[] { "Salt", "Rice", "Sugar", "Honey" }, 3, "Honey is the only food that never spoils!"));

	questionlist.add(
		new McQuestions("How many hearts does an octopus have?", new String[] { "One", "Two", "Three", "Four" },
			2, "An octopus has three hearts, two for the gills and one for the body"));

	questionlist.add(new McQuestions("How many books are in the Harry Potter series?",
		new String[] { "6", "7", "8", "9" }, 1, "There are seven books in the entire Harry Potter series."));

	questionlist.add(
		new McQuestions("Which one is the odd one out?", new String[] { "Ares", "Hades", "Zeus", "Apollo" }, 3,
			"Apollo is the odd one out, the others are all Greek gods, Apollo is Roman and Greek."));

	questionlist.add(new McQuestions("Which of the following men does not have a chemical element named for him?",
		new String[] { "Albert Einstein", "Niels Bohr", "Isaac Newton", "Enrico Fermi" }, 2,
		"Isaac Newton does not have an element named after him."));

	questionlist.add(new McQuestions("The Earth is approximately how many miles away from the Sun?",
		new String[] { "9.3 million", "39 million", "93 million", "193 million" }, 2,
		"The Earth is roughly 93 million miles from the Sun."));

	questionlist.add(new McQuestions("How many cards are in a standard deck of playing cards?",
		new String[] { "50", "52", "54", "56" }, 1, "A standard deck has 52 cards"));

	questionlist.add(new McQuestions("What video game characters specialize in plumbing?",
		new String[] { "Mario and Luigi", "Sonic and Tails", "Mega Man and Samus", "Sans and Papyrus" }, 0,
		"Mario and Luigi are the famous plumber brothers."));

	questionlist.add(new McQuestions("Which company created the Windows operating system?",
		new String[] { "Apple", "Google", "IBM", "Microsoft" }, 3,
		"Microsoft created the Windows operating system 1985."));

	questionlist.add(new McQuestions("Dubbed the “Black Death,” what plague swept through Europe in the 1300s?",
		new String[] { "Smallpox", "Bubonic Plague", "Cholera", "Influenza" }, 1,
		"The Bubonic Plague killed millions in Europe during the 1300s."));

	questionlist.add(new McQuestions("What year did World War I begin?",
		new String[] { "1910", "1912", "1914", "1920" }, 2, "World War I began in 1914."));

	questionlist.add(new McQuestions("What is the densest planet in our solar system?",
		new String[] { "Mars", "Neptune", "Saturn", "Earth" }, 3,
		"Earth is the densest planet in our solar system."));

	questionlist.add(new McQuestions("Which continent covers all four hemispheres of the Earth?",
		new String[] { "North America", "Africa", "Asia", "Europe" }, 1,
		"Africa is the only continent which covers all four hemispheres of the Earth."));

	questionlist.add(new McQuestions("Who wrote “To Kill a Mockingbird”?",
		new String[] { "Morgan Freeman", "Harper Lee", "Mark Twain", "F. Scott Fitzgerald" }, 1,
		"Harper Lee wrote the movie 'To Kill a Mockingbird.'"));

	questionlist.add(new McQuestions("Aside from the Nile, what is the longest river in the world?",
		new String[] { "Mississippi", "Yangtze", "Amazon", "Congo" }, 2,
		"The Amazon River is the longest river aside from the Nile"));

	questionlist.add(new McQuestions("How many moons does Neptune have?", new String[] { "12", "15", "14", "16" },
		2, "Neptune has 14 known moons"));

	questionlist.add(new McQuestions("In which decade was the first computer mouse publicly demonstrated?",
		new String[] { "1950s", "1960s", "1970s", "1980s" }, 1,
		"The first computer mouse was shown in 1968 by Douglas Engelbart."));

	questionlist
		.add(new McQuestions("How many folds are in a chef's hat?", new String[] { "50", "75", "100", "125" },
			2, "A chef's hat traditionally has 100 folds, symbolizing 100 ways to cook an egg!"));

	questionlist.add(new McQuestions("What is the chemical symbol for gold?",
		new String[] { "Au", "Ag", "Go", "Gd" }, 0, "The chemical symbol for gold is Au!"));

	Collections.shuffle(questionlist);
	TriviaGUI g1 = new TriviaGUI(questionlist);

	g1.InstructionsScreen();
    }

}
