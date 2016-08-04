package Language;

/**
 * Created by Nishanth on 28/06/2016.
 */
public class Word {

	private final String inputWord;
	private Classification classificiaton;

	public Word (String inputWord) {
		this.inputWord = inputWord;
		this.classificiaton = Classification.UNDEFINED;
	}

	public String getInputWord() {
		return inputWord;
	}

	public void setClassificiaton(Classification classificiaton) {
		this.classificiaton = classificiaton;
	}

	@Override
	public String toString() {
		return inputWord + " - " + classificiaton.toString();
	}

	@Override
	public boolean equals(Object obj) {
		return inputWord.equals(obj);
	}

	public Classification getClassification() {
		return classificiaton;
	}
}
