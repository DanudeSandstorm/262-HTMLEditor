package HTMLValidator;

/**
 * Represents the <ul> tag.
 * @author jakedulin
 */
public class UnorderedListTag implements Tag {

	private String name = "ul";

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
