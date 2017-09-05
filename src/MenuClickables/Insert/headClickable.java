package MenuClickables.Insert;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import HTMLHelper.TagMatcher;
import HTMLValidator.HeadTag;

/**
 * @author ?
 */
public class headClickable
{
	public static MenuItem setClickable(final String name)
	{
		MenuItem newItem = new MenuItem(name);
		newItem .setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                TagMatcher.generateTag(new HeadTag());
            }
        });
		return newItem;
	}

}
