package HTMLValidator;

/**
 * Represents the <html> tag.
 * @author jakedulin
 *
 */
public class HTMLTag implements Tag {

	private String name = "html";

        /**
         * @return The name of the string.
         */
	public String getName() {
		return name;
	}
	
        /**
         * @return Whether an end tag is required or not.
         */
	public boolean requiresEndTag() {
		return true;
	}
	
        /**
         * @return Whether the tag requires parameters to function.
         */
	public boolean requiresParameters() {
		return false;
	}

        /**
         * @return The current parameters in the tag.
         */
	public String getParameters() {
		return null;
	}

}
