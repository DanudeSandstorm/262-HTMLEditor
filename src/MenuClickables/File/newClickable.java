package MenuClickables.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import Editor.TabPanes;

/**
 * @author ?
 */
public class newClickable
{
	public static MenuItem setClickable(final String name)
	{
		MenuItem newItem = new MenuItem(name);
		newItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
				TabPanes tabPane = TabPanes.getInstance();
            	tabPane.newTab();
            }
        });
		return newItem;
	}
}
