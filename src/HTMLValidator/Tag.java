package HTMLValidator;

/**
 * Interface for all HTML tag constructs.
 * Could potentially add more to this later.
 * @author jakedulin
 */
public interface Tag {
	
	public String getName();
	
	public boolean requiresEndTag();
	
	public boolean requiresParameters();
	
	public String getParameters();
	
}
