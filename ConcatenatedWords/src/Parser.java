import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Parser {

	public String filePath = "";

	public Parser(String filePath) {
		super();
		this.filePath = filePath;
	}

	public ArrayList<String> parseFile() {
		FileInputStream fstream = null;
		DataInputStream dstream = null;
		BufferedReader breader = null;
		ArrayList<String> words = new ArrayList<String>();

		try {
			fstream = new FileInputStream(filePath);
			dstream = new DataInputStream(fstream);
			breader = new BufferedReader(new InputStreamReader(dstream));

			String line;

			while ((line = breader.readLine()) != null) {
				if (!line.isEmpty()) {
					words.add(line);
				}

			}
			words.trimToSize();
			sortArrayInDescendingOrder(words);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (breader != null) {
				try {
					breader.close();
				} catch (IOException e) {
				}
			}

		}
		
		return words;
	}

	public ArrayList<Integer> getIndexesOfWords(ArrayList<String> inputList) {
		ArrayList<Integer> emptyStringIndexes = new ArrayList<>();
		int placeOfCheckWord = 0;

		for (String word : inputList) {
			if (word.length() > 3) {
				int initialLength = word.length();
				for (int j = 1 + placeOfCheckWord; j < inputList.size(); j++) {
					if ((initialLength - 2) >= inputList.get(j).length()) {
						if (word.contains(inputList.get(j))) {
							word = word.replace(inputList.get(j), "");
							if (word.isEmpty()) {
								emptyStringIndexes.add(placeOfCheckWord);
							}
							System.out.println(word);
						}
					}
				}
			}
			placeOfCheckWord++;
		}
	
		emptyStringIndexes.trimToSize();
		
		return emptyStringIndexes;
	}

	public int countConcatWords(ArrayList<Integer> indexes) {

		return indexes.size();
	}

	public String findAndRemoveLongestWord(ArrayList<String> parsedList, ArrayList<Integer> indexes) {
		String max = "";
		int indexOfLongest = 0;
		for (int i = 0; i < indexes.size(); i++) {
			String temp = parsedList.get(indexes.get(i));
			if (max.length() < temp.length()) {
				max = temp;
				indexOfLongest = indexes.get(i);
			}

		}

		indexes.remove(indexOfLongest);
		
		return max;
	}

	public void sortArrayInDescendingOrder(ArrayList<String> listForSorting) {
		Collections.sort(listForSorting, new Comparator<String>() {
			public int compare(final String e1, final String e2) {
				if (e1.length() > e2.length())
					return -1;
				else if (e1.length() < e2.length())
					return 1;
				else
					return 0;
			}
		});
	}

}
