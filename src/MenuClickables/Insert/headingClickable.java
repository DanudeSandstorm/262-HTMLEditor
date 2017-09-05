package MenuClickables.Insert;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import HTMLHelper.TagMatcher;
import HTMLValidator.HeadingTag;

/**
 * @author ?
 */
public class headingClickable
{
	public static MenuItem setClickable(final String name, final int number)
	{
		MenuItem newItem = new MenuItem(name);
		newItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                TagMatcher.generateTag(new HeadingTag(number));
            }
        });
		return newItem;
	}
}
