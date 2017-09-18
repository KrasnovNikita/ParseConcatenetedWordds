import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Parser parser = new Parser("res//words.txt");
		ArrayList<String> words = parser.parseFile();
		ArrayList<Integer> indexes = parser.getIndexesOfWords(words);

		System.out.println("Quantity of fully cancateneted words: " + parser.countConcatWords(indexes));
		System.out.println("The longest concateneted word: " + parser.findAndRemoveLongestWord(words, indexes));
		System.out.println("The second longest concateneted word: " + parser.findAndRemoveLongestWord(words, indexes));

	}

}
