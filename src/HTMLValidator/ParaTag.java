package HTMLValidator;

/**
 * Represents the <p> tag.
 * @author jakedulin
 */
public class ParaTag implements Tag {

	private String name = "p";

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
