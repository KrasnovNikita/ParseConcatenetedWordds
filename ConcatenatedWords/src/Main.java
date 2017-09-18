import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Parser parser = new Parser("res//words.txt");
		ArrayList<String> longWords = parser.parseFile();
		ArrayList<Integer> indexes = parser.getIndexesOfWords(longWords);

		System.out.println("Quantity of fully cancateneted words: " + parser.countConcatWords(indexes));

		// System.out.println("The longest concateneted word: " +
		// main.findLongestWord());
		// System.out.println("The second longest concateneted word: " +
		// main.findLongestWord());

	}

}
