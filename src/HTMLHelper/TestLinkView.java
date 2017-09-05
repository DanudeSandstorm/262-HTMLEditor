package HTMLHelper;


/**
 * Tests LinkView's functionality.
 * @author jakedulin
 */
public class TestLinkView {

	// Tests LinkView's chronological and alphabetical views
	// with a simple test case.
	public static void main(String[] args) {
		System.out.println("Test Case 1");
		System.out.println(htmlTestCase1());
		System.out.println("All tests complete...");
	}
	
	// Four links, a-link.com and b-link.com each appearing twice
	public static String htmlTestCase1() {
		String myHTML = "<html>";
		myHTML += "<body>";
		myHTML += "<img src=\"http://www.a-link.com\">This is an image!</img>";
		myHTML += "<a href=\"http://www.b-link.com\">This is a link!</a>";
		myHTML += "<img src=\"http://www.a-link.com\">This is an image!</img>";
		myHTML += "<a href=\"http://www.b-link.com\">This is a link!</a>";
		myHTML += "<h1>Test cases are fun.</h1>";
		myHTML += "<p>";
		myHTML += "<b>";
		myHTML += "So much fun that they require bold text!";
		myHTML += "</b>";
		myHTML += "</p>";
		myHTML += "<table>";
		myHTML += "<tr>";
		myHTML += "<th>I like poop</th>";
		myHTML += "<th>A lot</th>";
		myHTML += "</tr>";
		myHTML += "</table>";
		myHTML += "<ul><li>Coffee</li><li>Tea</li><li>Milk</li></ul>";
		myHTML += "</body>";
		myHTML += "</html>";
		String result = "";
		if (LinkView.chronOrder(myHTML).equals(testCase1ChronOrder())) {
			result += "\tChronological Order Link View is working\n";
		} else {
			result += "\tChronological Order Link View is not working\n";
		}
		if (LinkView.alphOrder(myHTML).equals(testCase1AlphOrder())) {
			result += "\tAlphabetical Order Link View is working";
		} else {
			result += "\tAlphabetical Order Link View is not working";
		}
		return result;
	}
	
	// expected output of test case 1 chron order
	public static String testCase1ChronOrder() {
		String result = "http://www.a-link.com\n";
		result += "http://www.b-link.com\n";
		result += "http://www.a-link.com\n";
		result += "http://www.b-link.com\n";
		return result;
	}
	
	// expected output of test case 1 alph order
	public static String testCase1AlphOrder() {
		String result = "2 http://www.a-link.com\n";
		result += "2 http://www.b-link.com\n";
		return result;
	}
	
	
}
