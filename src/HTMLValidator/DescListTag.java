package HTMLValidator;

/**
 * Represents the <dl> tag.
 * @author jakedulin
 *
 */
public class DescListTag implements Tag {

	private String name = "dl";

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
