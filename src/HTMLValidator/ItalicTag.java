package HTMLValidator;

/**
 * Represents the <i> tag.
 * @author jakedulin
 */
public class ItalicTag implements Tag {

	private String name = "i";

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
