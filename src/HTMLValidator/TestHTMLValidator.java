package HTMLValidator;

/**
 * This class tests HTMLValidator.java
 * Run main() to run test suite.
 * @author jakedulin
 */
public class TestHTMLValidator {
	
	public static void main(String[] args) {
		System.out.println("Starting HTML Validation Tests...");
		System.out.print("\tTest Case 1 ");
		if (htmlTestCase1()) {
			System.out.println("passed");
		}
		else {
			System.out.println("FAILED");
		}
		System.out.print("\tTest Case 2 ");
		if (htmlTestCase2()) {
			System.out.println("passed");
		}
		else {
			System.out.println("FAILED");
		}
		System.out.print("\tTest Case 3 ");
		if (htmlTestCase3()) {
			System.out.println("passed");
		}
		else {
			System.out.println("FAILED");
		}
		System.out.print("\tTest Case 4 ");
		if (htmlTestCase4()) {
			System.out.println("passed");
		}
		else {
			System.out.println("FAILED");
		}
		System.out.print("\tTest Case 5 ");
		if (htmlTestCase5()) {
			System.out.println("passed");
		}
		else {
			System.out.println("FAILED");
		}
		System.out.print("\tTest Case 6 ");
		if (htmlTestCase6()) {
			System.out.println("passed");
		}
		else {
			System.out.println("FAILED");
		}
		System.out.println("Tests complete.");
	}
	
	// Basic test with valid HTML
	public static boolean htmlTestCase1() {
		String myHTML = "<html>";
		myHTML += "<body>";
		myHTML += "<p>";
		myHTML += "<b>";
		myHTML += "This is bold text";
		myHTML += "</b>";
		myHTML += "</p>";
		myHTML += "</body>";
		myHTML += "</html>";
		if (HTMLValidator.validateHTML(myHTML)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Basic test with invalid HTML
	public static boolean htmlTestCase2() {
		String myHTML = "<html>";
		myHTML += "<body>";
		myHTML += "<p>";
		myHTML += "<b>";
		myHTML += "This is bold text";
		//missing closing bold tag
		myHTML += "</p>";
		myHTML += "</body>";
		myHTML += "</html>";
		if (!HTMLValidator.validateHTML(myHTML)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Advanced test with valid HTML
	public static boolean htmlTestCase3() {
		String myHTML = "<html>";
		myHTML += "<body>";
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
		if (HTMLValidator.validateHTML(myHTML)) {
			return true;
		}
		else {
			return false;
		}
	}

	// Advanced test with invalid HTML
	public static boolean htmlTestCase4() {
		String myHTML = "<html>";
		myHTML += "<body>";
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
		myHTML += "<ul><li>Coffee</li><li>Tea<li>Milk</li></ul>";
		//missing closing li tag above
		myHTML += "</body>";
		myHTML += "</html>";
		if (!HTMLValidator.validateHTML(myHTML)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Advanced test with A/IMG tags, is valid
	public static boolean htmlTestCase5() {
		String myHTML = "<html>";
		myHTML += "<body>";
		myHTML += "<img src=\"http://www.google.com\">This is an image!</img>";
		myHTML += "<a href=\"http://www.google.com\">This is a link!</a>";
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
		if (HTMLValidator.validateHTML(myHTML)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Advanced test where IMG tag is invalid
	public static boolean htmlTestCase6() {
		String myHTML = "<html>";
		myHTML += "<body>";
		myHTML += "<img src=\"http://www.google.com>This is an image!</img>";
		myHTML += "<a href=\"http://www.google.com\">This is a link!</a>";
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
		if (!HTMLValidator.validateHTML(myHTML)) {
			return true;
		}
		else {
			return false;
		}
	}
	

}
