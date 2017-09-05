package HTMLValidator;

/**
 * Represents the <dt> tag.
 * @author jakedulin
 *
 */
public class DescTermTag implements Tag {

	private String name = "dt";

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
