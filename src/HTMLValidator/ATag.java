package HTMLValidator;

/**
 * Represents the a tag.
 * @author jakedulin
 */
public class ATag implements Tag {

	private String name = "a";
	
	public String getName() {
		return name;
	}

	public boolean requiresEndTag() {
		return true;
	}

	public boolean requiresParameters() {
		return true;
	}

	public String getParameters() {
		return "href";
	}

}
