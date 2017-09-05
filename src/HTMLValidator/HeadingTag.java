package HTMLValidator;

/**
 * Represents the <h1> to <h6> tags.
 * @author jakedulin
 */
public class HeadingTag implements Tag {

	private String name = "h";
	private int headingNumber;
	
	public HeadingTag(int number) {
		this.setNumber(number);
	}
	
	public void setNumber(int number) {
		this.headingNumber = number;
		this.name += this.headingNumber;
	}

	public String getName() {
		return name;
	}
	
	public boolean requiresEndTag() {
		return true;
	}
	
	public boolean requiresParameters() {
		return false;
	}

	public String getParameters() {
		return null;
	}

}
