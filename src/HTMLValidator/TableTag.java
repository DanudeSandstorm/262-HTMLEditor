package HTMLValidator;

/**
 * Represents the <table> tag.
 * @author jakedulin
 *
 */
public class TableTag implements Tag {

	private String name = "table";

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
