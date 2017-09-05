package HTMLValidator;

/**
 * Represents the <head> tag.
 * @author jakedulin
 */
public class HeadTag implements Tag {

	private String name = "head";

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
