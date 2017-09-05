
package HTMLHelper;

import java.io.IOException;
import java.util.ArrayList;

public class HtmlConstruct implements HtmlObject
{
	private String openTag;
	private String closeTag;
	private int[] startPos;
	private int[] endPos;
	private int indentLevel;
	private ArrayList<HtmlObject> items;
	private boolean isVisible;

	/**
	 * Constructor for creating new HtmlConstruct with a parent HtmlConstruct.
	 * 
	 * @param parent
	 *            : The parent HtmlConstruct of the new HtmlConstruct.
	 * @param tag
	 *            : The tag to be made into a construct.
	 * @param attributes
	 *            : Any attributes within the tag.
	 * @param items
	 *            : HtmlObjects within the new HtmlConstruct.
	 */
	public HtmlConstruct(String openTag, String closeTag, int[] startPos, int[] endPos, int indendLevel, HtmlObject... items)
	{
		this.openTag = openTag;
		this.closeTag = closeTag;
		this.startPos = startPos;
		this.endPos = endPos;
		this.indentLevel = indendLevel;
		for (HtmlObject i : items)
		{
			this.items.add(i);
		}
	}

	/**
	 * @return The current indentation level.
	 */
	public int getIndentLevel()
	{
		return indentLevel;
	}

	/**
	 * Sets the indentation level to whatever's passed in.
	 * 
	 * @param indentLevel
	 *            : The level to set indentation to.
	 */
	public void setIndentLevel(int indentLevel)
	{
		this.indentLevel = indentLevel;
	}

	/**
	 * @return All HtmlObject items within the HtmlConstruct.
	 */
	public ArrayList<HtmlObject> getItems()
	{
		return items;
	}

	/**
	 * @return The visual representation of the HtmlConstruct's tag.
	 * @throws IOException
	 */
	public String getText() throws IOException
	{
		String text = "";
		if (isVisible)
		{
			text += openTag;

			for (HtmlObject item : items)
			{
				text += item.getText();
			}

			text += closeTag;
		}
		else
		{
			text = openTag;
		}

		// Handle indentation?
		/*
		 * BufferedReader reader = new BufferedReader(new StringReader(text));
		 * 
		 * String line = ""; String indText = ""; while (( line =
		 * reader.readLine()) != null) { //System.out.println("Line: " + line);
		 * for (int i = 0; i < indentLevel; i++) { indText+= "\t"; } indText +=
		 * line + "\n"; //System.out.println("IndText: " + indText); }
		 */
		return text;
	}

	/**
	 * @param tag
	 *            : What the HtmlConstruct's tag should be.
	 */
	public void setOpenTag(String tag)
	{
		this.openTag = tag;
	}

	/**
	 * @return The HtmlConstruct's tag.
	 */
	public String getOpenTag()
	{
		return openTag;
	}

	public void setCloseTag(String tag)
	{
		this.closeTag = tag;
	}

	/**
	 * @return The HtmlConstruct's tag.
	 */
	public String getCloseTag()
	{
		return closeTag;
	}
	
	/**
	 * @param isVisible
	 *            : Whether the HtmlConstruct should be visible or not.
	 */
	public void setVisible(boolean isVisible)
	{
		this.isVisible = isVisible;
	}

	/**
	 * @return Whether the HtmlConstruct is currently visable or not.
	 */
	public boolean isVisible()
	{
		return isVisible;
	}

	/**
	 * @return the startPos
	 */
	public int[] getStartPos()
	{
		return startPos;
	}

	/**
	 * @param startPos
	 *            the startPos to set
	 */
	public void setStartPos(int[] startPos)
	{
		this.startPos = startPos;
	}

	/**
	 * @return the endPos
	 */
	public int[] getEndPos()
	{
		return endPos;
	}

	/**
	 * @param endPos
	 *            the endPos to set
	 */
	public void setEndPos(int[] endPos)
	{
		this.endPos = endPos;
	}
}
