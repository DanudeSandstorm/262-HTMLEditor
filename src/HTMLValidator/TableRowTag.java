package HTMLValidator;

/**
 * Represents the <tr> tag.
 * @author jakedulin
 *
 */
public class TableRowTag implements Tag {

	private String name = "tr";

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
