package HTMLValidator;

/**
 * Represents the <td> tag.
 * @author jakedulin
 *
 */
public class TableDataTag implements Tag {
	
	private String name = "td";

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
