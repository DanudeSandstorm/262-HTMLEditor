package HTMLValidator;

/**
 * Represents the <dd> tag.
 * @author jakedulin
 *
 */
public class DescDescTag implements Tag {

	private String name = "dd";

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
