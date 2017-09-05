package HTMLHelper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class responsible for converting a string of HTML
 * into a Link View.
 * Has two methods, one for chronological order and
 * one for alphabetical order.
 * Its tester class is TestLinkView.java in the same package.
 * @author jakedulin
 */
public class LinkView {

	// chronological order link view
	public static String chronOrder(String html) {
		String result = "";
		// separate input by quotes (URLs always in quotes)
        String [] parts = html.split("\"");
        // Attempt to convert each item into an URL.   
        for( String item : parts )
	        try {
	            URL url = new URL(item);
	            result += url + "\n";
	        } catch (MalformedURLException e) {}
		return result;
	}
	
	// alphabetical order link view
	public static String alphOrder(String html) {
		String result = "";
		HashMap<String, Integer> allUrls = new HashMap<String, Integer>();
		// separate input by quotes (URLs always in quotes)
		String[] parts = html.split("\"");
		// Attempt to convert each item into an URL.
		for (String item : parts)
			try {
				URL url = new URL(item);
				if (allUrls.containsKey(url.toString())) {
					int oldValue = allUrls.get(url.toString());
					allUrls.put(url.toString(), oldValue+=1);
				} else {
					allUrls.put(url.toString(), 1);
				}
			} catch (MalformedURLException e) {
			}
		ArrayList<String> allKeys = new ArrayList<String>(allUrls.keySet());
		java.util.Collections.sort(allKeys);
		for (String key : allKeys) {
			int oldValue = allUrls.get(key);
			if (oldValue <= 1) {
				result += key + "\n";
			} else {
				result += oldValue + " " + key + "\n";
			}
		}
		return result;
	}
	
}
