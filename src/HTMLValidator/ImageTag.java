package HTMLValidator;

/**
 * Represents the image tag.
 * @author jakedulin
 */
public class ImageTag implements Tag {

	private String name = "img";

	public String getName() {
		return name;
	}
	
	public boolean requiresEndTag() {
		return true;
	}
	
	public boolean requiresParameters() {
		return true;
	}

	public String getParameters() {
		return "src";
	}

}
