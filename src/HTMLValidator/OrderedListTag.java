package HTMLValidator;

/**
 * Represents the <ol> tag.
 * @author jakedulin
 */
public class OrderedListTag implements Tag {

	private String name = "ol";

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
