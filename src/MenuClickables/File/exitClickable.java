package MenuClickables.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import Editor.CheckClosed;

/**
 * @author ?
 */
public class exitClickable
{
	public static MenuItem setCLickable(final String name)
	{
		// TODO Auto-generated method stub
		MenuItem newItem = new MenuItem(name);
		newItem.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent e) {
				CheckClosed.close();
			}
		});
		return newItem;
	}
}
