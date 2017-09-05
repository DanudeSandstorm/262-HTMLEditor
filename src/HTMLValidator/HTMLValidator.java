package HTMLValidator;

import java.util.ArrayList;
import java.util.Stack;

/**
 * This is the sole class responsible for validating HTML.
 * @author Jake Dulin <jad5366@rit.edu>
 */
public class HTMLValidator {

	/**
	 * Checks to see if a string of text is valid HTML.
	 * @param html the string of HTML to validate
	 * @return boolean true if valid HTML, false if not
	 */
	public static boolean validateHTML(String html) {
		Stack<Tag> unclosedTags = new Stack<Tag>();
		String currTag = "";
		boolean inTag = false;
		for (int i = 0; i < html.length(); i++) {
			char currChar = html.charAt(i);
			if (currChar == '<') {
				inTag = true;
				currTag += currChar;
			}
			else if (inTag) {
				currTag += currChar;
				if (currChar == '>') {
					if (!validateTag(currTag, unclosedTags)) { return false; }
					inTag = false;
					currTag = "";
				}
			}
		}
		if (unclosedTags.isEmpty()) { return true; }
		return false;
	}
	
	/**
	 * Validates an individual HTML tag.
	 * @param tag string representing tag that we found in input
	 * @param unclosedTags stack of all unclosedTags
	 * @return boolean true if tag is valid html, false if not valid tag
	 * or the tag was improperly placed
	 */
	public static boolean validateTag(String tag, Stack<Tag> unclosedTags) {
		ArrayList<Tag> possibleTags = generatePossibleTags();
		boolean isStartTag = false;
		if (isValidStartTag(tag)) {
			isStartTag = true;
		} else if (!isValidEndTag(tag)) {
			return false;
		}
		for (Tag currTag : possibleTags) {
			String currTagType = currTag.getName().toLowerCase();
			String tagType = getTagType(tag);
			if (currTagType.equalsIgnoreCase(tagType)) {
				if (isStartTag) {
					unclosedTags.push(currTag);
				} else {
					if (unclosedTags.peek().getName().equalsIgnoreCase(tagType)) {
						unclosedTags.pop();
					} else {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Is this tag a start tag?
	 */
	public static boolean isValidStartTag(String tag) {
		String regex = "</?\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)/?>";
		return tag.matches(regex) && tag.charAt(1) != '/';
	}
	
	/**
	 * Is this tag an end tag?
	 */
	public static boolean isValidEndTag(String tag) {
		String regex = "</?\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)/?>";
		return tag.matches(regex) && tag.charAt(1) == '/';
	}
	
	/**
	 * What type of tag is this?
	 * @return string representing the tag type
	 */
	public static String getTagType(String tag) {
		String type = "";
		for (int i = 1; i < tag.length(); i++) {
			char currChar = tag.charAt(i);
			if (currChar == ' ' || currChar == '>') {
				return type;
			}
			else if (currChar != '/') {
				type += currChar;
			}
		}
		return type;
	}
	
		
	
	/**
	 * Generates an ArrayList containing one reference
	 * to each ConcreteTag class. This is how our system
	 * knows if a tag typed by the user is in fact a valid tag
	 * or not. All tags typed by the user are compared to
	 * these tags to check for validity.
	 * @return ArrayList of all "known-to-be-valid" tags
	 */
	public static ArrayList<Tag> generatePossibleTags() {
		ArrayList<Tag> allTags = new ArrayList<Tag>();

		allTags.add(new HTMLTag());
		allTags.add(new BodyTag());
		allTags.add(new HeadTag());
		allTags.add(new BoldTag());
		allTags.add(new ItalicTag());
		allTags.add(new ParaTag());
		allTags.add(new DescDescTag());
		allTags.add(new DescListTag());
		allTags.add(new DescTermTag());

		allTags.add(new HeadingTag(1));
		allTags.add(new HeadingTag(2));
		allTags.add(new HeadingTag(3));
		allTags.add(new HeadingTag(4));
		allTags.add(new HeadingTag(5));
		allTags.add(new HeadingTag(6));

		allTags.add(new OrderedListTag());
		allTags.add(new UnorderedListTag());
		allTags.add(new ListItemTag());
		allTags.add(new TableDataTag());
		allTags.add(new TableHeadingTag());
		allTags.add(new TableRowTag());
		allTags.add(new TableTag());
		
		allTags.add(new ATag());
		allTags.add(new ImageTag());

		return allTags;
	}
}
