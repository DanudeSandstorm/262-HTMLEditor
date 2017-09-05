package HTMLHelper;

/**
 * 
 * @author ?
 */
public class TextLeaf implements HtmlObject
{
	private String text;
	
        /**
         * @param text: The text to turn into a TextLeaf.
         */
	public TextLeaf(String text)
	{
		this.text = text;
	}
	
        /**
         * @return The text in the TextLeaf.
         */
	public String getText()
	{
		return text;
	}
	
        /**
         * @param text: What to set as the TextLeaf's text.
         */
	public void setText(String text)
	{
		this.text = text;
	}
}
