package HTMLValidator;

/**
 * Represents the <b> tag.
 * @author jakedulin
 */
public class BoldTag implements Tag {

	private String name = "b";

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
