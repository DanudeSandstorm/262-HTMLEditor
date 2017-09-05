package HTMLValidator;

/**
 * Represents the <th> tag.
 * @author jakedulin
 *
 */
public class TableHeadingTag implements Tag {

	private String name = "th";

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
