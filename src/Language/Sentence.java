package Language;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Nishanth on 28/06/2016.
 */
public class Sentence {

	private ArrayList<Word> words;

	public Sentence (String inputSentence) {
		this.words = initialise(inputSentence);
	}

	private ArrayList<Word> initialise(String inputSentence) {
		inputSentence = inputSentence.toLowerCase();
		String[] temp = inputSentence.split(" ");

		ArrayList<Word> tempArray = new ArrayList<>();

		for (int i = 0; i < temp.length; i++) {
			tempArray.add(new Word(temp[i]));
		}
		return tempArray;
	}

	public void classify () {
		for (int i = 0; i < words.size(); i++) {
			Classifier.classify(words.get(i));
		}
	}

	public void removeUnclassified () {
		Iterator<Word> iter = words.iterator();
		while (iter.hasNext()) {
			Word word = iter.next();
			if (word.getClassification() == Classification.NONE) {
				iter.remove();
			}
		}
	}

	@Override
	public String toString() {
		String temp = "";
		for (int i = 0; i < words.size(); i++) {
			temp = temp + words.get(i).getInputWord() + " ";
		}
		return temp;
	}

	public ArrayList<Word> getWords() {
		return words;
	}
}
