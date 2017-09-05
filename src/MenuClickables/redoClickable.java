package MenuClickables;

import Editor.TextBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public class redoClickable {
	public static MenuItem setClickable(final String name)
	{
		MenuItem newItem = new MenuItem(name);
		
		newItem.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent t)
			{
				//call the redo command for the current text area
				TextBox.getController(TextBox.getActiveTextArea()).redo();;
			}
		});
		return newItem;
	}
}
