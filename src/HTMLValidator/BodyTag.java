package HTMLValidator;

/**
 * Represents the <body> tag.
 * @author jakedulin
 */
public class BodyTag implements Tag {

	private String name = "body";

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
