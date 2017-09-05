
package HTMLHelper;

import java.io.IOException;

public class TestHtmlObject
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String testText = "This is a test string. My name is Josh.";
		HtmlConstruct header1 = new HtmlConstruct("h1", "",
			new TextLeaf(testText));

		String testText2 = "This is another test string. My last name is Berk";
		HtmlConstruct div = new HtmlConstruct("div",
			"class = \"myClass\"", header1,
			new HtmlConstruct("p", "", new TextLeaf(testText2)));
		
		try
		{
			System.out.println("Test starts here:");
			System.out.println(header1.getText());
			//System.out.println("Added indentation level of 1:");
			//paragraph.setIndentLevel(1);
			//System.out.println(paragraph.getText());
			
			System.out.println("Test 2 starts here:");
			System.out.println(div.getText());
			
			System.out.println("Test 3 starts here:");
			HtmlConstruct div2 = new HtmlConstruct(div);
			div2.setVisible(false);
			System.out.println(div2.getText());
		}
		catch (IOException e)
		{
			System.err.println("Caught IOException: "
				+ e.getMessage());
		}
	}
}
