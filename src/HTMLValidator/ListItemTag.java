package HTMLValidator;

/**
 * Represents the <li> tag.
 * @author jakedulin
 */
public class ListItemTag implements Tag {

	private String name = "li";

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
