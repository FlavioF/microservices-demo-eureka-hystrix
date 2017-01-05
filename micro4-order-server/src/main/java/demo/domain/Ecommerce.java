package demo.domain;

/**
 * 'Ecommerce' object is nicely represented in JSON over a regular String.
 */
public class Ecommerce {

	public String word;

	public Ecommerce() {
		super();
	}	
	
	public Ecommerce(String word) {
		this();
		this.word = word;
	}

	public String getWord() {
		return word;
	}
	
	public String getString() {
		return getWord();
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	
}
