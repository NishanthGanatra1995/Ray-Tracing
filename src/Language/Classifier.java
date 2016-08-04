package Language;

/**
 * Created by Nishanth on 28/06/2016.
 */
public class Classifier {

	public Classifier () {
	}

	public static void classify (Word word) {
		if (word.equals("one") || word.equals("two") || word.equals("three") || word.equals("four") || word.equals("five") || word.equals("six")
				|| word.equals("seven") || word.equals("eight") || word.equals("nine") || word.equals("ten") ) {
			word.setClassificiaton(Classification.NUMBER);
		} else if (word.equals("sphere") || word.equals("plane")) {
			word.setClassificiaton(Classification.SHAPE);
		} else word.setClassificiaton(Classification.NONE);
	}
}
